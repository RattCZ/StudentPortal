$('document').ready(function() {

	$('.table .btn-warning').on('click',function(event){

		event.preventDefault();

		var href= $(this).attr('href');

		$.get(href, function(student, status){
			$('#IdEdit').val(student.id);
			$('#nameEdit').val(student.firstname);
			$('#departmentEdit').val(student.surname);
			$('#updatedByEdit').val(student.mail);
		});

		$('#editModal').modal();

	});

	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();

	});

});