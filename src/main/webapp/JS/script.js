/**
 * Javascript Document to handle page changes.
 */

/**
 * Variables that catch HTML elements.
 */
const links = document.querySelectorAll('#menu a');
const mainCont = document.getElementById('mainCont');

function appendCom() {
	const XHTTP = new XMLHttpRequest();
	XHTTP.open('POST', '/FoodForAll/showCommunity', false);
	XHTTP.send();
	createSelectCom(XHTTP.responseText, 'txtCom');
}

function appendFeed() {
	const XHTTPF = new XMLHttpRequest();
	XHTTPF.open('POST', '/FoodForAll/showFeed', false);
	XHTTPF.send();
	createSelectPr(XHTTPF.responseText, 'txtDes');
}

/**
 * Method that catch the id of each element 
 * and charges the content of main container.
 */
links.forEach((link) => {
	const formXHTTP = new XMLHttpRequest();
	link.addEventListener('click', function(e) {
		e.preventDefault();
		let id = e.target.getAttribute("id");
		if (id == 'Donate') {
			setTimeout(() => {
				appendCom();
				const donBtn = document.getElementById('btnDonate');
				donBtn.addEventListener('click', () => {
					donate();
				});
			}, 500);
		}
		else if (id == 'Benef') {
			setTimeout(() => {
				appendCom();
				const donBtn = document.getElementById('btnRegister');
				donBtn.addEventListener('click', () => {
					regBenef();
				});
			}, 500);
		}
		else if (id == 'Query') {
			setTimeout(() => {
				appendFeed();
				const donBtn = document.getElementById('btnQuery');
				donBtn.addEventListener('click', () => {
					query();
				});
			}, 500);
		}
		links.forEach((link) => link.classList.remove('active'));
		e.target.classList.add('active');
		formXHTTP.open('GET', id + '.html', true);
		
		formXHTTP.send();
	});
	formXHTTP.onload = function() {
		mainCont.innerHTML = this.responseText;
	}
});


/**
 * Functions for request data from BD and show in the UI
 */
function createSelectCom(json_res) {

	const json = JSON.parse(json_res);

	for (let j = 0; j < json.length; j++) {
		let option = document.createElement('option');
		option.value = json[j].communityId;
		option.text = json[j].communityName;
		document.getElementById('txtCom').appendChild(option);
	}

}

function createSelectPr(json_res) {

	const json = JSON.parse(json_res);

	for (let j = 0; j < json.length; j++) {
		let option = document.createElement('option');
		option.text = json[j].name;
		document.getElementById('txtDes').appendChild(option);
	}

}

/**
 * Functions for each form
 */

/**
 * Functions for validate data
 */

/**
 * This function allows to validate the donor data
 */
function valDonate() {

	const type = document.getElementById('txtDonor');
	const name = document.getElementById('txtName');
	const email = document.getElementById('txtEmail');
	const phone = document.getElementById('txtPhone');
	const community = document.getElementById('txtCom');
	let valType = type.options[type.selectedIndex];
	let valCom = community.options[community.selectedIndex];
	const donationName = document.getElementById('txtDonation');
	const donationCant = document.getElementById('txtCant');
	const prType = document.getElementById('txtPr');
	let valPrType = prType.options[prType.selectedIndex];
	const prStatus = document.getElementById('txtPr');
	let valPrStatus = prStatus.options[prStatus.selectedIndex];

	if (valType.value == 'em') {
		alert('Tipo de donador no es valido');
		return false;
	} else if (name.value.trim().length == 0) {
		alert('Nombre no puede estar vacio');
		return false;
	} else if (email.value.trim().length == 0) {
		alert('E-mail no puede estar vacio');
		return false;
	} else if (phone.value.trim().length == 0) {
		alert('Telefono no puede estar vacio');
		return false;
	} else if (valCom.value == 'em') {
		alert('Comunidad no es valida');
		return false;
	} else if (donationName.value.trim().length == 0) {
		alert('Debes donar algo');
		return false;
	} else if (donationCant.value.trim() < 1) {
		alert('Cantidad invalida');
		return false;
	} else if (valPrType.value == 'em') {
		alert('Tipo de producto no valido');
		return false;
	} else if (valPrStatus.value == 'em') {
		alert('Estado de producto no valido');
		return false;
	} else {
		return true;
	}

}

/**
 * This function allows to validate the benef register
 */
function valBenefData() {

	const dni = document.getElementById('txtDni');
	const name = document.getElementById('txtName');
	const age = document.getElementById('txtAge');
	const strat = document.getElementById('txtStrat');
	const phone = document.getElementById('txtPhone');
	const email = document.getElementById('txtEmail');
	const community = document.getElementById('txtCom');
	let valCom = community.options[community.selectedIndex];

	if (dni.value.trim().length == 0) {
		alert('Dni no es valido');
		return false;
	} else if (name.value.trim().length == 0) {
		alert('Nombre no puede estar vacio');
		return false;
	} else if (age.value.trim().length == 0 || age.value.trim() >= 18) {
		alert('Edad no es valido');
		return false;
	} else if (strat.value.trim().length == 0 || strat.value.trim() == '4' || strat.value.trim() == '5' || strat.value.trim() == '6') {
		alert('Estrato no es valido');
		return false;
	} else if (phone.value.trim().length == 0) {
		alert('Telefono no puede estar vacio');
		return false;
	} else if (email.value.trim().length == 0) {
		alert('E-mail no puede estar vacio');
		return false;
	} else if (valCom.value == 'em') {
		alert('Comunidad no es valida');
		return false;
	} else {
		return true;
	}

}

/**
 * This function allows to validate the benef register
 */
function valQuery() {

	const dni = document.getElementById('txtDni');
	const products = document.getElementById('txtDes');
	let valPr = products.options[products.selectedIndex];

	if (valPr.value == 'em') {
		alert('Selecciona un producto');
		return false;
	} else if (dni.value.trim().length == 0) {
		alert('No estas en la base de datos');
		return false;
	} else {
		return true;
	}

}

/**
 * Donate allows a person register the food donation,
 * in any condition(long time before expire, close to expire, expired)
 */
function donate() {
	/**
	 * Donor data variables
	 */
	const type = document.getElementById('txtDonor');
	let valType = type.options[type.selectedIndex];
	const name = document.getElementById('txtName').value.trim();
	const email = document.getElementById('txtEmail').value.trim();
	const phone = document.getElementById('txtPhone').value.trim();
	const community = document.getElementById('txtCom');
	let valCom = community.options[type.selectedIndex];
	const donationName = document.getElementById('txtDonation').value.trim();
	const donationCant = document.getElementById('txtCant').value.trim();
	const prType = document.getElementById('txtPr');
	let valPrType = prType.options[prType.selectedIndex];
	const prStatus = document.getElementById('txtStPr');
	let valPrStatus = prStatus.options[prStatus.selectedIndex];
	const httpD = new XMLHttpRequest();

	let valid = valDonate();

	if (valid) {

		/**
		* Parameters for Create donation
		*/

		let params = 'nameD=' + name + '&emailD=' + email + '&phoneD=' + phone + '&typeD=' + valType.text + '&communityD=' + valCom.value + '&nameF=' + donationName + '&typeF=' + valPrType.text + '&countF=' + donationCant + '&statusF=' + valPrStatus.text;

		httpD.open('POST', '/FoodForAll/createDonation', true);

		httpD.setRequestHeader('Content-type',
			'application/x-www-form-urlencoded');

		if (httpD.status == 200) {
			alert("creado");
		} else {
			alert('no creado');
		}

		httpD.send(params);
	}

}

/**
 * RegBenef allows to register a beneficiary for request a product
 */

function regBenef() {
	const dni = document.getElementById('txtDni').value.trim();
	const name = document.getElementById('txtName').value.trim();
	const age = document.getElementById('txtAge').value.trim();
	const strat = document.getElementById('txtStrat').value.trim();
	const phone = document.getElementById('txtPhone').value.trim();
	const email = document.getElementById('txtEmail').value.trim();
	const community = document.getElementById('txtCom');
	let valCom = community.options[community.selectedIndex];
	const httpR = new XMLHttpRequest();

	let valid = valBenefData();

	if (valid) {

		/**
		* Parameters for Create donation
		*/

		let params = 'identify=' + dni + '&name=' + name + '&age=' + age + '&strat=' + strat + '&email=' + email + '&phone=' + phone + '&community=' + valCom.value;

		httpR.open('POST', '/FoodForAll/createBeneficed', true);

		httpR.setRequestHeader('Content-type',
			'application/x-www-form-urlencoded');

		if (httpR.status == 200) {
			alert("creado");
		} else {
			alert('no creado');
		}


		httpR.send(params);
	}

}

/**
 * query allows to the beneficiary knows what could request
 */
function query() {

	const dni = document.getElementById('txtDni').value.trim();

	const httpQ = new XMLHttpRequest();

	let valid = valQuery();

	if (valid) {

		/**
		* Parameters for Create donation
		*/

		let params = `dni=${dni}`;

		httpQ.open('POST', '/FoodForAll/ShowBeneficiaries', true);

		httpQ.setRequestHeader('Content-type',
			'application/x-www-form-urlencoded');
		console.log(httpQ.status)

		httpQ.onreadystatechange = function() {
			if (httpQ.readyState == 4 && httpQ.status == 200) {
				if (httpQ.responseText === "[]") {
					alert('No puedes acceder al beneficio');
				}
				else {
					alert('Puedes recoger los productos en el centro de acopio mas cercano');
				}
			}
		}
        if (httpQ.readyState == 4 && httpQ.status == 200) {
            if (httpQ.responseText === '[]') {
                alert('No puedes acceder al beneficio');
            }
        } else {
            alert('Puedes recoger los productos en el centro de acopio mas cercano');
        }

		httpQ.send(params);
	}

}