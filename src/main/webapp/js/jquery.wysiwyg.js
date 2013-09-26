/**
 * WYSIWYG - jQuery plugin 0.5
 *
 * Copyright (c) 2008-2009 Juan M Martinez
 * http://plugins.jquery.com/project/jWYSIWYG
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 *
 * jQueryId: jQuery
 */
(function( jQuery )
{
    jQuery.fn.document = function()
    {
        var element = this[0];

        if ( element.nodeName.toLowerCase() == 'iframe' )
            return element.contentWindow.document;
            /*
            return ( jQuery.browser.msie )
                ? document.frames[element.id].document
                : element.contentWindow.document // contentDocument;
             */
        else
            return jQuery(this);
    };

    jQuery.fn.documentSelection = function()
    {
        var element = this[0];

        if ( element.contentWindow.document.selection )
            return element.contentWindow.document.selection.createRange().text;
        else
            return element.contentWindow.getSelection().toString();
    };

    jQuery.fn.wysiwyg = function( options )
    {
        if ( arguments.length > 0 && arguments[0].constructor == String )
        {
            var action = arguments[0].toString();
            var params = [];

            for ( var i = 1; i < arguments.length; i++ )
                params[i - 1] = arguments[i];

            if ( action in Wysiwyg )
            {
                return this.each(function()
                {
                    jQuery.data(this, 'wysiwyg')
                     .designMode();

                    Wysiwyg[action].apply(this, params);
                });
            }
            else return this;
        }

        var controls = {};

        /**
         * If the user set custom controls, we catch it, and merge with the
         * defaults controls later.
         */
        if ( options && options.controls )
        {
            var controls = options.controls;
            delete options.controls;
        }

        var options = jQuery.extend({
            html : '<'+'?xml version="1.0" encoding="UTF-8"?'+'><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"><html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">STYLE_SHEET</head><body style="color:#656769;font-family: Verdana, Arial, Helvetica, sans-serif !important; font-size: 13px; height: 100%; line-height: 1.5em !important;">INITIAL_CONTENT</body></html>',
            css  : {},

            debug        : false,

            autoSave     : true,  // http://code.google.com/p/jwysiwyg/issues/detail?id=11
            rmUnwantedBr : true,  // http://code.google.com/p/jwysiwyg/issues/detail?id=15
            brIE         : true,

            controls : {},
            messages : {}
        }, options);

        options.messages = jQuery.extend(true, options.messages, Wysiwyg.MSGS_EN);
        options.controls = jQuery.extend(true, options.controls, Wysiwyg.TOOLBAR);

        for ( var control in controls )
        {
            if ( control in options.controls )
                jQuery.extend(options.controls[control], controls[control]);
            else
                options.controls[control] = controls[control];
        }

        // not break the chain
        return this.each(function()
        {
            Wysiwyg(this, options);
        });
    };

    function Wysiwyg( element, options )
    {
        return this instanceof Wysiwyg
            ? this.init(element, options)
            : new Wysiwyg(element, options);
    }

    jQuery.extend(Wysiwyg, {
        insertImage : function( szURL, attributes )
        {
            var self = jQuery.data(this, 'wysiwyg');

            if ( self.constructor == Wysiwyg && szURL && szURL.length > 0 )
            {
                if ( attributes )
                {
                    self.editorDoc.execCommand('insertImage', false, '#jwysiwyg#');
                    var img = self.getElementByAttributeValue('img', 'src', '#jwysiwyg#');

                    if ( img )
                    {
                        img.src = szURL;

                        for ( var attribute in attributes )
                        {
                            img.setAttribute(attribute, attributes[attribute]);
                        }
                    }
                }
                else
                {
                    self.editorDoc.execCommand('insertImage', false, szURL);
                }
            }
        },

        createLink : function( szURL )
        {
            var self = jQuery.data(this, 'wysiwyg');

            if ( self.constructor == Wysiwyg && szURL && szURL.length > 0 )
            {
                var selection = jQuery(self.editor).documentSelection();

                if ( selection.length > 0 )
                {
                    self.editorDoc.execCommand('unlink', false, []);
                    self.editorDoc.execCommand('createLink', false, szURL);
                }
                else if ( self.options.messages.nonSelection )
                    alert(self.options.messages.nonSelection);
            }
        },

        setContent : function( newContent )
        {
            var self = jQuery.data(this, 'wysiwyg');
                self.setContent( newContent );
                self.saveContent();
        },

        clear : function()
        {
            var self = jQuery.data(this, 'wysiwyg');
                self.setContent('');
                self.saveContent();
        },

        MSGS_EN : {
            nonSelection : 'select the text you wish to link'
        },

        TOOLBAR : {
            bold          : { visible : true, tags : ['b', 'strong'], css : { fontWeight : 'bold' } },
            italic        : { visible : true, tags : ['i', 'em'], css : { fontStyle : 'italic' } },
            strikeThrough : { visible : false, tags : ['s', 'strike'], css : { textDecoration : 'line-through' } },
            underline     : { visible : false, tags : ['u'], css : { textDecoration : 'underline' } },

            separator00 : { visible : false, separator : true },

            justifyLeft   : { visible : false, css : { textAlign : 'left' } },
            justifyCenter : { visible : false, tags : ['center'], css : { textAlign : 'center' } },
            justifyRight  : { visible : false, css : { textAlign : 'right' } },
            justifyFull   : { visible : false, css : { textAlign : 'justify' } },

            separator01 : { visible : false, separator : true },

            indent  : { visible : false },
            outdent : { visible : false },

            separator02 : { visible : false, separator : true },

            subscript   : { visible : false, tags : ['sub'] },
            superscript : { visible : false, tags : ['sup'] },

            separator03 : { visible : false, separator : true },

            undo : { visible : false },
            redo : { visible : false },

            separator04 : { visible : false, separator : true },

            insertOrderedList    : { visible : false, tags : ['ol'] },
            insertUnorderedList  : { visible : false, tags : ['ul'] },
            insertHorizontalRule : { visible : false, tags : ['hr'] },

            separator05 : { separator : true },

            createLink : {
                visible : true,
                exec    : function()
                {
                    var selection = jQuery(this.editor).documentSelection();

                    if ( selection.length > 0 )
                    {
                        if ( jQuery.browser.msie )
                            this.editorDoc.execCommand('createLink', true, null);
                        else
                        {
                            var szURL = prompt('URL', 'http://');

                            if ( szURL && szURL.length > 0 )
                            {
                                this.editorDoc.execCommand('unlink', false, []);
                                this.editorDoc.execCommand('createLink', false, szURL);
                            }
                        }
                    }
                    else if ( this.options.messages.nonSelection )
                        alert(this.options.messages.nonSelection);
                },

                tags : ['a']
            },

            insertImage : {
                visible : true,
                exec    : function()
                {
                    if ( jQuery.browser.msie )
                        this.editorDoc.execCommand('insertImage', true, null);
                    else
                    {
                        var szURL = prompt('URL', 'http://');

                        if ( szURL && szURL.length > 0 )
                            this.editorDoc.execCommand('insertImage', false, szURL);
                    }
                },

                tags : ['img']
            },

            separator06 : { separator : true },

            h1mozilla : { visible : true && jQuery.browser.mozilla, className : 'h1', command : 'heading', arguments : ['h1'], tags : ['h1'] },
            h2mozilla : { visible : true && jQuery.browser.mozilla, className : 'h2', command : 'heading', arguments : ['h2'], tags : ['h2'] },
            h3mozilla : { visible : true && jQuery.browser.mozilla, className : 'h3', command : 'heading', arguments : ['h3'], tags : ['h3'] },

            h1 : { visible : true && !( jQuery.browser.mozilla ), className : 'h1', command : 'formatBlock', arguments : ['Heading 1'], tags : ['h1'] },
            h2 : { visible : true && !( jQuery.browser.mozilla ), className : 'h2', command : 'formatBlock', arguments : ['Heading 2'], tags : ['h2'] },
            h3 : { visible : true && !( jQuery.browser.mozilla ), className : 'h3', command : 'formatBlock', arguments : ['Heading 3'], tags : ['h3'] },

            separator07 : { visible : false, separator : true },

            cut   : { visible : false },
            copy  : { visible : false },
            paste : { visible : false },

            separator08 : { separator : true && !( jQuery.browser.msie ) },

            increaseFontSize : { visible : true && !( jQuery.browser.msie ), tags : ['big'] },
            decreaseFontSize : { visible : true && !( jQuery.browser.msie ), tags : ['small'] },

            separator09 : { separator : true },

            html : {
                visible : false,
                exec    : function()
                {
                    if ( this.viewHTML )
                    {
                        this.setContent( jQuery(this.original).val() );
                        jQuery(this.original).hide();
                    }
                    else
                    {
                        this.saveContent();
                        jQuery(this.original).show();
                    }

                    this.viewHTML = !( this.viewHTML );
                }
            },

            removeFormat : {
                visible : true,
                exec    : function()
                {
                    this.editorDoc.execCommand('removeFormat', false, []);
                    this.editorDoc.execCommand('unlink', false, []);
                }
            }
        }
    });

    jQuery.extend(Wysiwyg.prototype,
    {
        original : null,
        options  : {},

        element  : null,
        editor   : null,

        init : function( element, options )
        {
            var self = this;

            this.editor = element;
            this.options = options || {};

            jQuery.data(element, 'wysiwyg', this);

            var newX = element.width || element.clientWidth;
            var newY = element.height || element.clientHeight;

            if ( element.nodeName.toLowerCase() == 'textarea' )
            {
                this.original = element;

                if ( newX == 0 && element.cols )
                    newX = ( element.cols * 8 ) + 21;

                if ( newY == 0 && element.rows )
                    newY = ( element.rows * 16 ) + 16;

                var editor = this.editor = jQuery('<iframe></iframe>').css({
                    minHeight : ( newY - 6 ).toString() + 'px',
                    width     : ( newX - 8 ).toString() + 'px'
                }).attr('id', jQuery(element).attr('id') + 'IFrame');

                if ( jQuery.browser.msie )
                {
                    this.editor
                        .css('height', ( newY ).toString() + 'px');

                    /**
                    var editor = jQuery('<span></span>').css({
                        width     : ( newX - 6 ).toString() + 'px',
                        height    : ( newY - 8 ).toString() + 'px'
                    }).attr('id', jQuery(element).attr('id') + 'IFrame');

                    editor.outerHTML = this.editor.outerHTML;
                     */
                }
            }

            var panel = this.panel = jQuery('<ul></ul>').addClass('panel');

            this.appendControls();
            this.element = jQuery('<div></div>').css({
                width : ( newX > 0 ) ? ( newX ).toString() + 'px' : '100%'
            }).addClass('wysiwyg')
              .append(panel)
              .append( jQuery('<div><!-- --></div>').css({ clear : 'both' }) )
              .append(editor);

            jQuery(element)
            // .css('display', 'none')
            .hide()
            .before(this.element);

            this.viewHTML = false;

            this.initialHeight = newY - 8;

            /**
             * @link http://code.google.com/p/jwysiwyg/issues/detail?id=52
             */
            this.initialContent = jQuery(element).val();

            this.initFrame();

            if ( this.initialContent.length == 0 )
                this.setContent('');

            if ( this.options.autoSave )
                jQuery('form').submit(function() { self.saveContent(); });

            jQuery('form').bind('reset', function()
            {
                self.setContent( self.initialContent );
                self.saveContent();
            });
        },

        initFrame : function()
        {
            var self = this;
            var style = '';

            /**
             * @link http://code.google.com/p/jwysiwyg/issues/detail?id=14
             */
            if ( this.options.css && this.options.css.constructor == String )
                style = '<link rel="stylesheet" type="text/css" media="screen" href="' + this.options.css + '" />';

            this.editorDoc = jQuery(this.editor).document();
            this.editorDoc_designMode = false;

            try {
                this.editorDoc.designMode = 'on';
                this.editorDoc_designMode = true;
            } catch ( e ) {
                // Will fail on Gecko if the editor is placed in an hidden container element
                // The design mode will be set ones the editor is focused

                jQuery(this.editorDoc).focus(function()
                {
                    self.designMode();
                });
            }

            this.editorDoc.open();
            this.editorDoc.write(
                this.options.html
                    .replace(/INITIAL_CONTENT/, this.initialContent)
                    .replace(/STYLE_SHEET/, style)
            );
            this.editorDoc.close();
            this.editorDoc.contentEditable = 'true';

            if ( jQuery.browser.msie )
            {
                /**
                 * Remove the horrible border it has on IE.
                 */
                setTimeout(function() { jQuery(self.editorDoc.body).css('border', 'none'); }, 0);
            }

            jQuery(this.editorDoc).click(function( event )
            {
                self.checkTargets( event.target ? event.target : event.srcElement);
            });

            /**
             * @link http://code.google.com/p/jwysiwyg/issues/detail?id=20
             */
            jQuery(this.original).focus(function()
            {
                jQuery(self.editorDoc.body).focus();
            });

            if ( this.options.autoSave )
            {
                /**
                 * @link http://code.google.com/p/jwysiwyg/issues/detail?id=11
                 */
                jQuery(this.editorDoc).keydown(function() { self.saveContent(); })
                                 .keyup(function() { self.saveContent(); })
                                 .mousedown(function() { self.saveContent(); });
            }

            if ( this.options.css )
            {
                setTimeout(function()
                {
                    if ( self.options.css.constructor == String )
                    {
                        /**
                         * jQuery(self.editorDoc)
                         * .find('head')
                         * .append(
                         *     jQuery('<link rel="stylesheet" type="text/css" media="screen" />')
                         *     .attr('href', self.options.css)
                         * );
                         */
                    }
                    else
                        jQuery(self.editorDoc).find('body').css(self.options.css);
                }, 0);
            }

            jQuery(this.editorDoc).keydown(function( event )
            {
                if ( jQuery.browser.msie && self.options.brIE && event.keyCode == 13 )
                {
                    var rng = self.getRange();
                        rng.pasteHTML('<br />');
                        rng.collapse(false);
                        rng.select();

    				return false;
                }
            });
        },

        designMode : function()
        {
            if ( !( this.editorDoc_designMode ) )
            {
                try {
                    this.editorDoc.designMode = 'on';
                    this.editorDoc_designMode = true;
                } catch ( e ) {}
            }
        },

        getSelection : function()
        {
            return ( window.getSelection ) ? window.getSelection() : document.selection;
        },

        getRange : function()
        {
            var selection = this.getSelection();

            if ( !( selection ) )
                return null;

            return ( selection.rangeCount > 0 ) ? selection.getRangeAt(0) : selection.createRange();
        },

        getContent : function()
        {
            return jQuery( jQuery(this.editor).document() ).find('body').html();
        },

        setContent : function( newContent )
        {
            jQuery( jQuery(this.editor).document() ).find('body').html(newContent);
        },

        saveContent : function()
        {
            if ( this.original )
            {
                var content = this.getContent();

                if ( this.options.rmUnwantedBr )
                    content = ( content.substr(-4) == '<br>' ) ? content.substr(0, content.length - 4) : content;

                jQuery(this.original).val(content);
            }
        },

        appendMenu : function( cmd, args, className, fn )
        {
            var self = this;
            var args = args || [];

            jQuery('<li></li>').append(
                jQuery('<a><!-- --></a>').addClass(className || cmd)
            ).mousedown(function() {
                if ( fn ) fn.apply(self); else self.editorDoc.execCommand(cmd, false, args);
                if ( self.options.autoSave ) self.saveContent();
            }).appendTo( this.panel );
        },

        appendMenuSeparator : function()
        {
            jQuery('<li class="separator"></li>').appendTo( this.panel );
        },

        appendControls : function()
        {
            for ( var name in this.options.controls )
            {
                var control = this.options.controls[name];

                if ( control.separator )
                {
                    if ( control.visible !== false )
                        this.appendMenuSeparator();
                }
                else if ( control.visible )
                {
                    this.appendMenu(
                        control.command || name, control.arguments || [],
                        control.className || control.command || name || 'empty', control.exec
                    );
                }
            }
        },

        checkTargets : function( element )
        {
            for ( var name in this.options.controls )
            {
                var control = this.options.controls[name];
                var className = control.className || control.command || name || 'empty';

                jQuery('.' + className, this.panel).removeClass('active');

                if ( control.tags )
                {
                    var elm = element;

                    do {
                        if ( elm.nodeType != 1 )
                            break;

                        if ( jQuery.inArray(elm.tagName.toLowerCase(), control.tags) != -1 )
                            jQuery('.' + className, this.panel).addClass('active');
                    } while ( elm = elm.parentNode );
                }

                if ( control.css )
                {
                    var elm = jQuery(element);

                    do {
                        if ( elm[0].nodeType != 1 )
                            break;

                        for ( var cssProperty in control.css )
                            if ( elm.css(cssProperty).toString().toLowerCase() == control.css[cssProperty] )
                                jQuery('.' + className, this.panel).addClass('active');
                    } while ( elm = elm.parent() );
                }
            }
        },

        getElementByAttributeValue : function( tagName, attributeName, attributeValue )
        {
            var elements = this.editorDoc.getElementsByTagName(tagName);

            for ( var i = 0; i < elements.length; i++ )
            {
                var value = elements[i].getAttribute(attributeName);

                if ( jQuery.browser.msie )
                {
                    /** IE add full path, so I check by the last chars. */
                    value = value.substr(value.length - attributeValue.length);
                }

                if ( value == attributeValue )
                    return elements[i];
            }

            return false;
        }
    });
})(jQuery);