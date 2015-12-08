$(document).ready(function() {
	alert("Page loaded");
	
	
	$("#buttn").click(function() {
		alert("Button clicked");
		$.ajax({
			url: '/login',
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(item)
		}).then(
		function(items){
		}
	});
});