const checkbox = document.querySelector(".header__checkbox");
const box = document.querySelector(".header-nav");

checkbox.addEventListener("change", () => {
  box.classList.toggle("hidden");
});


var button = document.getElementById("reseva");
var drop = document.querySelector(".dropdown__menu");

button.addEventListener("click", function () {
  alert("boton presionado");
});



