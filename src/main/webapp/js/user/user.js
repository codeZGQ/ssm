
window.onload = function() {
	var val = $("input[type='hidden']").val();
	$('select:eq(0)').val(val);
}
$(function() {
	function pages(page) {
		$.post(
			"user/selectPage",
			{
				"page" : page
			},
			function(data) {
				$('#t1 tr:not(:first)').remove();
				$.each(data, function(index, con) {
					var tr = $('<tr/>');
					$('<td/>').html(con.id).appendTo(tr);
					$('<td/>').html(con.name).appendTo(tr);
					$('<td/>').html(con.pwd).appendTo(tr);
					tr.appendTo('#t1');
				})
			},
			"json"
		)
	}

	$("#last").click(function() {
		var current = $('#current').html();
		var p = $('#pages').html();
		if (current == p) {
			return;
		}
		pages(p);

		$('#current').html(p);
	})

	$("#next").click(function() {
		var current = $('#current').html();
		var p = $('#pages').html();
		if (current == p) {
			return;
		}
		pages(parseInt(current) + 1);

		$('#current').html(parseInt(current) + 1);
	})

	$("#previous").click(function() {
		var current = $('#current').html();
		if (current == 1) {
			return;
		}
		pages(parseInt(current) - 1);

		$('#current').html(parseInt(current) - 1);
	})

	$("#first").click(function() {
		var current = $('#current').html();
		if (current == 1) {
			return;
		}
		pages(1);

		$('#current').html(1);
	})

	$('select:eq(0)').change(function() {
		var val = $(this).val();
		$.jsPost("user/listUser", {
			"pageSize" : val
		});
	})

	$.extend({
		jsPost : function(url, args) {
			var form = $("<form method='post'/>");
			form.attr("action", url);
			$.each(args, function(key, value) {
				var input = $("<input type='hidden'/>");
				input.attr("name", key);
				input.val(value);
				input.appendTo(form);
			});
			form.submit();
		}
	})
});