/* ------------------------------------------------------------------------
	Do it when you're ready dawg!
------------------------------------------------------------------------- */


	tabs = {
  init : function(){
   jQuery('.tabs').each(function(){

    var th=jQuery(this),
     tContent=jQuery('.tab-content',th),
     navA=jQuery('ul.nav a',th)

    tContent.not().hide();
	tab_act=jQuery('ul.nav .selected a').attr('href');
	jQuery(tab_act).show();

    navA.click(function(){
     var th=jQuery(this),
      tmp=th.attr('href')
     tContent.not(jQuery(tmp.slice(tmp.indexOf('#'))).fadeIn(600)).hide()
	 jQuery(th).parent().addClass('selected').siblings().removeClass('selected');
     return false;
    });
   });

  }
 };
