function includeHTML() {
  var z, i, elmnt, file, xhttp;
  /* Loop through a collection of all HTML elements: */
  z = document.getElementsByTagName("*");
  for (i = 0; i < z.length; i++) {
    elmnt = z[i];
    /*search for elements with a certain atrribute:*/
    file = elmnt.getAttribute("w3-include-html");
    if (file) {
      /* Make an HTTP request using the attribute value as the file name: */
      xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
          if (this.status == 200) { elmnt.innerHTML = this.responseText; }
          if (this.status == 404) { elmnt.innerHTML = "Page not found."; }
          /* Remove the attribute, and call this function once more: */
          elmnt.removeAttribute("w3-include-html");
          includeHTML();
        }
      }
      xhttp.open("GET", file, true);
      xhttp.send();
      /* Exit the function: */
      return;
    }
  }
}


function includeData() {
  $(document).ready(function () {
    // RECUPERANDO DATOS DESDE JSON (jQuery)
    $.getJSON("/data/categories.json",
      function (data) {
        var category = '';

        // ITERACIÓN POR LOS OBJETOS y construcción de string
        $.each(data, function (key, value) {
          category += '<li><a class="dropdown-item" href="foro/' + value.path + '">' + value.title + "</a></li>";
        });

        // INSERTAR FILA A LA lista
        $('#categories-dropdown').append(category);
      });
  });
}