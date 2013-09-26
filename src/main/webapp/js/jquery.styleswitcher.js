/*
 * Simplpan Admin Panel
 *
 * Copyright (c) 2011 Kasper Kismul
 *
 * http://themeforest.net/user/Kaasper/profile
 *
 * This adds cookie for style and width aswell as change style based on user input.
 *
 */

//-------------------------------------------------------------- */
//
// 	**** Styleswitch Cookie (Cookie) **** 
//
// 	For more information go to:
//	https://github.com/carhartl/jquery-cookie
//
//-------------------------------------------------------------- */

// Checks if you've set a theme already
if(jQuery.cookie("theme")) {
	// Sets the theme that the cookie finds
	jQuery("link.theme").attr("href",("./css/theme/" + jQuery.cookie("theme") + ".css"));
};

// Checks if you've set a width already
if(jQuery.cookie("width")) {
	// Sets the width that the cookie finds
	jQuery("link.width").attr("href",("./css/" + jQuery.cookie("width") + ".css"));
};

//-------------------------------------------------------------- */
// Style Switcher
//-------------------------------------------------------------- */

jQuery(document).ready(function() { 
	
	// Checks if you've set a theme already
	if(jQuery.cookie("theme")) {
		// Sets cookie as selected
		jQuery("#style li").find('a[hrefjQuery=' + jQuery.cookie("theme") + ']').addClass("selected");
	}
	else {
		jQuery("#style li").find('a[hrefjQuery=' + "blue" + ']').addClass("selected");
	}
	
	// If you change style..
	jQuery("#style li a").click(function() { 
		
		// Gets the style you've selected and adds the .css
		var jQuerytheme = "./css/theme/" + (jQuery(this).attr('href').replace("#","")) + ".css";
		
		// Replaces the theme's css
		jQuery("link.theme").attr("href", jQuerytheme);
		
		// Removes other selected classes and adds it to the selected theme
		jQuery(this).parent().parent().find("a").removeClass("selected");
		jQuery(this).addClass("selected");
		
		// Sets cookie
		jQuery.cookie("theme",jQuery(this).attr('href').replace("#",""), {expires: 365, path: '/'});
		return false; // Prevents going to top when pressing "#" link
	});

//-------------------------------------------------------------- */
// Width Switcher
//-------------------------------------------------------------- */

	// Checks if you've set a width already
	if(jQuery.cookie("width")) {
		// Sets cookie as selected
		jQuery("#width li").find('a[hrefjQuery=' + jQuery.cookie("width") + ']').addClass("selected");
	}
	else {
		jQuery("#width li").find('a[hrefjQuery=' + "fixed" + ']').addClass("selected");
	}

	// If you change width..
	jQuery("#width li a").click(function() { 
		
		// Gets the with you've selected and adds the .css
		var jQuerywidthCss = "./css/" + (jQuery(this).attr('href').replace("#","")) + ".css";
		
		// Replaces the width's css
		jQuery("link.width").attr("href", jQuerywidthCss);
		jQuery('table.stats').trigger('visualizeRefresh');
		
		// Removes other selected classes and adds it to the selected width
		jQuery(this).parent().parent().find("a").removeClass("selected");
		jQuery(this).addClass("selected");
		
		// Sets cookie
		jQuery.cookie("width",jQuery(this).attr('href').replace("#",""), {expires: 365, path: '/'});
		return false; // Prevents going to top when pressing "#" link
	});	


// jQuery End	
});