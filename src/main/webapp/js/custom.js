/*
 * Simplpan Admin Panel
 *
 * Copyright (c) 2011 Kasper Kismul
 *
 * http://themeforest.net/user/Kaasper/profile
 *
 * This file configures all the different jQuery scripts used in the Simplpan Admin Panel template. 
 *
 */

//-------------------------------------------------------------- */
// Inserts "v"'s for dropdowns before documment load
//-------------------------------------------------------------- */

// Inserts the "v" Icon
jQuery("<span class='v'></span>").insertBefore("#userpanel ul.dropdown ul.subnav");
	
// Inserts the "v" Icon
jQuery("<span class='v'></span>").insertAfter("ul#navigation.dropdown ul.subnav");

//-------------------------------------------------------------- */
// When document is loaded, load custom jQuery
//-------------------------------------------------------------- */

(function (jQuery){
   jQuery(document).ready(function() {

	
//-------------------------------------------------------------- */
// Box Slider
//-------------------------------------------------------------- */

	// When top box is clicked, it slides up
	jQuery(".box_top h2").click(function(){
		jQuery(this).toggleClass("toggle_closed").parent().next().slideToggle("slow");
		return false; //Prevent the browser jump to the link anchor
	}); 

//-------------------------------------------------------------- */
//
// 	**** Accordion (jQuery UI) **** 
//
// 	For more information go to:
//	http://jqueryui.com/demos/
//
//-------------------------------------------------------------- */

	jQuery( ".accordion" ).accordion();

//-------------------------------------------------------------- */
// Box Tabs
//-------------------------------------------------------------- */

	jQuery('div.tabs').each(function() {
		

		var jQuerytabs_name = jQuery(this);
		
		// If there is a tab, find the active
		if (jQuery(this).parent().prev().children('ul.sorting').length) {
			
			// Sorting shortcut
			var jQuerytabs_tabs = jQuery(this).parent().prev().children('ul.sorting');
			
			// If it active, then show it
			if (jQuery(jQuerytabs_tabs).children().children('a').hasClass('active')) {
					
				// Finds the href and removes the #
				var jQuerystats_type = jQuery(jQuerytabs_tabs).children().find('.active').attr('href');
					
				jQuery(jQuerytabs_tabs).children().children('a').each(function() {
					var jQuerytab_names = jQuery(this).attr('href');
					// Hides all
					jQuery(jQuerytabs_name).find(jQuerytab_names).hide();
				});
					
				jQuery(jQuerytabs_name).find(jQuerystats_type).show();
			};
	
			// When one of the tabs are clicked
			jQuery(jQuerytabs_tabs).children().children('a').click(function(){
				
				jQuery(jQuerytabs_tabs).children().children('a').each(function() {
					var jQuerytab_names = jQuery(this).attr('href');
					// Hides all
					jQuery(jQuerytabs_name).find(jQuerytab_names).hide();
				});
				
				// The href without #
				var jQuerytabs_tabs_type = jQuery(this).attr('href');
				
				// Fades inn the one thats clicked
				jQuery(jQuerytabs_name).parent().find(jQuerytabs_tabs_type).fadeIn('slow');
				
				// Removes 'active' class
				jQuery(jQuerytabs_tabs).children().children('a').removeClass('active');
				
				// Adds active state to the one you clicked
				jQuery(this).addClass('active');
				return false; //Prevent the browser jump to the link anchor
			}); 
		};	
		
	});

//-------------------------------------------------------------- */
//
// 	**** Table Sorting (DataTables) **** 
//
// 	For more information go to:
//	http://www.datatables.net/
//
//-------------------------------------------------------------- */

	// Table Sorting with every feature (search, pagination..)
	jQuery('table.sorting').dataTable( {
		"sPaginationType": "full_numbers",
		"bAutoWidth": false
	} );
	
	// Table Sorting with only pagination
	jQuery('table.simple_sorting').dataTable( {
		"sPaginationType": "full_numbers",
		"bFilter": false,
		"bLengthChange": false,
		"bSort": false,
		"bSortClasses": false,
		"bAutoWidth": false
	} );
	
	// Removes sorting information if there are table actions due to space issues
	if (jQuery('.table_actions')) {
		jQuery('.table_actions').each(function() {
			jQuery(this).parent().find('.dataTables_info').hide();
		});	
	};

//-------------------------------------------------------------- */
//
// 	**** Popups (Facebox) **** 
//
// 	For more information go to:
//	http://defunkt.io/facebox/
//
//-------------------------------------------------------------- */

	jQuery('.popup').facebox();

//-------------------------------------------------------------- */
//
// 	**** Tips (Poshytip) **** 
//
// 	For more information go to:
//	http://vadikom.com/demos/poshytip/
//
//-------------------------------------------------------------- */

	// Tip for home icon etc.
	jQuery('.tip').poshytip({
		className: 'tip-theme',
		showTimeout: 1,
		alignTo: 'target',
		alignX: 'center',
		alignY: 'bottom',
		offsetX: 0,
		offsetY: 16,
		allowTipHover: false,
		fade: false,
		slide: false
	});
	
	// Tip that stays
	jQuery('.tip-stay').poshytip({
		className: 'tip-theme',
		showOn:'focus',
		showTimeout: 1,
		alignTo: 'target',
		alignX: 'center',
		alignY: 'bottom',
		offsetX: 0,
		offsetY: 16,
		allowTipHover: false,
		fade: false,
		slide: false
	});

//-------------------------------------------------------------- */
// Removal of notice boxes when pressed
//-------------------------------------------------------------- */

	// When notice box is clicked
	jQuery("div.notice, p.error, p.warning, p.info, p.note, p.success").click(function() { 
		jQuery(this).fadeOut('slow');
	});   

//-------------------------------------------------------------- */
//
// 	**** Datepicker (jQuery UI) **** 
//
// 	For more information go to:
//	http://jqueryui.com/demos/
//
//-------------------------------------------------------------- */
	
	// Select date
	jQuery("input.date").datepicker();
	
	// Inline date
	jQuery(".inlinedate").datepicker();

//-------------------------------------------------------------- */
// Validation
//-------------------------------------------------------------- */

	// Validator function
	function validation(){

		// Does the validation on blur (when you go to off the input field)
		jQuery(".validate").blur(function () {
			
			// If something is not typed, error icon
			if (jQuery(this).val() === ""){
				jQuery(this).removeClass("validate_success");
		    	jQuery(this).addClass("validate_error");
		    	return false;
			}
			
			// If something is typed, success icon
			else {
				jQuery(this).removeClass("validate_error");
		    	jQuery(this).addClass("validate_success");
		    	return true;
			};
			
		});

	};

	// Calls the validator function when focusing on an input field
	jQuery(".validate").focus(function () {
	      return validation();
	});
	

//-------------------------------------------------------------- */
// Drop Downs
//-------------------------------------------------------------- */

// User Panel Dropdown
	
	// When hovering over a ul element with "dropdown" class
	jQuery("#userpanel ul.dropdown").hover(function() { 
	  
		// Sets the top text as active (the dropdown)
		jQuery(this).find(".top").addClass("active");
		
		// Slides the "subnav" on hover
		jQuery(this).find("ul.subnav").show();
		// Shows the white 'v'
		jQuery(this).find("span.v").addClass("active");
	  
		// On hover off
		jQuery(this).hover(function() {  
		}, function(){  
			
			// Hides the subnavigation when isn't on the "subnav" anymore
			jQuery(this).find("ul.subnav").stop(false, true).hide(); 
			
			// Removes top text as active (the dropdown)
			jQuery(this).find(".top").removeClass("active");
			
			// Hides the white 'v'
			jQuery(this).find("span.v").removeClass("active");
		});  
	});  

// Navigation Dropdown

	// When hovering over a ul element with "dropdown" class
	jQuery("ul#navigation.dropdown li.topnav").hover(function() { 
	
		// Copys the navigation name and the "v" icon to the top of the dropdown
		jQuery(this).clone().prependTo("ul#navigation.dropdown .subnav");
		jQuery("ul#navigation.dropdown .subnav .subnav").remove();	
		
		// Slides the "subnav" on hover
		jQuery(this).find("ul.subnav").show();
		
		// On hover off
		jQuery("ul#navigation.dropdown ul.subnav").parent().hover(function() {  
		  jQuery("ul#navigation.dropdown .subnav .topnav").remove();
		}, function(){  
			
			// Hides the subnavigation when isn't on the "subnav" anymore
			jQuery(this).find("ul.subnav").stop(false, true).hide(); 
			
			// Removes the top part to prevent duplication
			jQuery("ul#navigation.dropdown .subnav .topnav").remove();
		});  
	});  

//-------------------------------------------------------------- */
//
// 	**** Form Elements (uniform) **** 
//
// 	For more information go to:
//	http://uniformjs.com/
//
//-------------------------------------------------------------- */

jQuery(".box_content select, .box_content input:checkbox, .box_content input:radio, .box_content input:file, .box_content button").uniform();

//-------------------------------------------------------------- */
// Check all checkboxes
//-------------------------------------------------------------- */

	jQuery('.checkall').click(function () {
		var checkall =jQuery(this).parents('.box_content:eq(0)').find(':checkbox').attr('checked', this.checked);
		jQuery.uniform.update(checkall);
	});


// End jQuery
   });
})(jQuery);

