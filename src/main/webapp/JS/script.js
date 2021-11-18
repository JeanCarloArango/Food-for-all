/**
 * Javascript Document to handle window changes
 */

/**
 * Variables that catch HTML elements
 */
const links = document.querySelectorAll('#menu a');
const mainCont = document.getElementById('mainCont');
const formXHTTP = new XMLHttpRequest();

links.forEach((link) => {
    link.addEventListener('click', function(e) {
        e.preventDefault();
        let id = e.target.getAttribute("id");
        console.log(id);
        formXHTTP.open('GET', id + '.html', true);
        formXHTTP.send();
    });
});

formXHTTP.onload = function () {
    mainCont.innerHTML = this.responseText;
}