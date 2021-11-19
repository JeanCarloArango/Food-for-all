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

    console.log(json);

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
    } else if(valCom.value == 'em') {
        alert('Comunidad no es valida');
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
    const name = document.getElementById('txtName').value.trim();
    const email = document.getElementById('txtEmail').value.trim();
    const phone = document.getElementById('txtPhone').value.trim();
    const community = document.getElementById('txtCom');
    let valType = type.options[type.selectedIndex];
    let valCom = community.options[type.selectedIndex];

    let params = `name=${name}&email=${email}&phone=${phone}&community=${valCom.value}&type=${valType.text}`;

    const http = new XMLHttpRequest();

    http.open('POST', '/showFood', true);

    alert(http.responseText);

    http.send

}