/**
 * Javascript Document to handle page changes.
 */

/**
 * Variables that catch HTML elements.
 */
const links = document.querySelectorAll('#menu a');
const mainCont = document.getElementById('mainCont');
const formXHTTP = new XMLHttpRequest();

/**
 * Method that catch the id of each element 
 * and charges the content of main container.
 */
links.forEach((link) => {
    link.addEventListener('click', function (e) {
        e.preventDefault();
        let id = e.target.getAttribute("id");
        if (id == 'Donate') {
            setTimeout(() => {
                const donBtn = document.getElementById('btnDonate');
                donBtn.addEventListener('click', () => {
                    donate()
                });
            }, 500);
        }
        // if (id == 'Benef') {
        //     regBenef();
        // }
        // if (id == 'Query') {
        //     query()
        // }
        links.forEach((link) => link.classList.remove('active'));
        e.target.classList.add('active');
        formXHTTP.open('GET', id + '.html', true);
        formXHTTP.send();
    });
});

formXHTTP.onload = function () {
    mainCont.innerHTML = this.responseText;
}

/**
 * Function for request data from BD and show in the UI
 */
function createSelect(json_res) {

    const json = JSON.parse(json_res);

    let keyName = [];

    for(let j = 0; j < json.length; j++) {
        for(let key in json[j]) {
            if(keyName.indexOf(key) === -1) {
                keyName.push(key);
            }
        }
    }

    alert(keyName);

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
    let valCom = community.options[type.selectedIndex];
    const donationName = document.getElementById('txtDonation');
    const donationCant = document.getElementById('txtCant');
    const prType = document.getElementById('txtPr');
    let valPrType = prType.options[prType.selectedIndex];
    const prStatus = document.getElementById('txtPr');
    let valPrStatus = prStatus.options[prStatus.selectedIndex];

    if(valType.value == 'em') {
        alert('Tipo de donador no es valido');
        return false;
    } else if(name.value.trim().length == 0) {
        alert('Nombre no puede estar vacio');
        return false;
    } else if(email.value.trim().length == 0) {
        alert('E-mail no puede estar vacio');
        return false;
    } else if(phone.value.trim().length == 0) {
        alert('Telefono no puede estar vacio');
        return false;
    } /*else if(valCom.value == 'em') {
        alert('Comunidad no es valida');
        return false;
    }*/ else if(donationName.value.trim().length == 0) {
        alert('Debes donar algo');
        return false;
    } else if(donationCant.value.trim() < 1) {
        alert('Cantidad invalida');
        return false;
    } else if(valPrType.value == 'em') {
        alert('Tipo de producto no valido');
        return false;
    } else if(valPrStatus.value == 'em') {
        alert('Estado de producto no valido');
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

    let params = 'nameD='+name+'&emailD='+email+'&phoneD='+phone+'&type='+valType.text+'&community=11'+/*valCom.text*/+'&nameF='+donationName+'&typeF='+valPrType.text+'&countF='+donationCant+'&statusF'+valPrStatus.text;

    const http = new XMLHttpRequest();

    http.open('POST', '/createDonation', true);

    http.send(params);

}