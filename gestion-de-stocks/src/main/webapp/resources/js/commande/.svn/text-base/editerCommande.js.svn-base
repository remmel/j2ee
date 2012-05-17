function getQteByIdProduit() {

	// get the form values
	var id = $('#idProduit').val();

	if (id == null || id == "") {
		$('#prixUnitaire').val("-");

	} else {
		$.ajax({
			type : "POST",
			url : urlGetPrixByIdProduit,
			data : "id=" + id,
			success : function(response) {
				$('#prixUnitaire').val(response);
			},
			error : function(e) {

				alert('Error: ' + e);
			}
		});
	}

	modifierPrixTotal();
}

function modifierPrixTotal() {
	var prixTotal;

	if ($('#prixUnitaire').val() == "-") {
		prixTotal = "0";

	} else {
		prixTotal = $('#prixUnitaire').val() * $('#quantite').val();
	}

	$('#prix').val(prixTotal);

}