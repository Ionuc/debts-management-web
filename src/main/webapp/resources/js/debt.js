$(document).ready(
		function() {

			var origin = window.location.origin
			var projectName = window.location.pathname.split("/")[1]
			var jsonPath = origin + '/' + projectName + '/allUsers.json'
			$.getJSON(jsonPath, {
				ajax : 'true'
			}, function(data) {
				var html = '<option value="">--Please select one--</option>';
				var len = data.length;
				for (var i = 0; i < len; i++) {
					html += '<option value="' + data[i].username + '">'
							+ data[i].username + '</option>';
				}
				html += '</option>';

				$('#toUsernameSelectPickerId').html(html);
				$('#fromUsernameSelectPickerId').html(html);

			})
		});

$(document).ready(function() {
	$('#datetimepicker1').datetimepicker();
});