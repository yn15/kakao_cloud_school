$(function() {
	
	$("li").on('mouseover', function(){
		$(this).addClass("myStyle");
	});
	
	$("li").on('mouseleave', function(){
		$(this).removeClass("myStyle");
	});
	
});