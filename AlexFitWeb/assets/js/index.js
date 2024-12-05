const checkbox = document.querySelector(".header__checkbox");
const checkboxClose = document.querySelector(".icon-close");
const navBox = document.querySelector(".header-nav");
const blur = document.querySelector(".blur");

// Aseguramos que ambas clases se apliquen de manera coherente
checkbox.addEventListener("click", () => {
  if (blur.classList.contains("show")) {
    // Si "show" ya está presente, ocultamos ambos
    blur.classList.remove("show");
    navBox.classList.add("hidden");
  } else {
    // Si "show" no está presente, mostramos ambos
    blur.classList.add("show");
    navBox.classList.remove("hidden");
  }
});

// Cerrar el menú con el icono de cerrar
checkboxClose.addEventListener("click", () => {
  // Ambas clases se deben ocultar al cerrar
  navBox.classList.add("hidden");
  blur.classList.remove("show");
});

blur.addEventListener("click", () => {
  // Ambas clases se deben ocultar al cerrar
  navBox.classList.add("hidden");
  blur.classList.remove("show");
});






/*Dropdown con click*/
// asegura de carga el DOM
document.addEventListener('DOMContentLoaded', () => {
  // Seleccionar TODOS los elementos card
  const cards = document.querySelectorAll(".card");

  // Recorrer cada card
  cards.forEach(card => {
    // Seleccionar elementos DENTRO de cada card específica
    const cardHeader = card.querySelector(".card-header");
    const cardContent = card.querySelector(".card_content");
    const dropdown = card.querySelector(".dropdown__arrow");

    // Agregar evento solo a ese header específico
    cardHeader.addEventListener("click", () => {
      card.classList.toggle("show_card");
      cardContent.classList.toggle("show_cardContent");
      dropdown.classList.toggle("rotated");
    });
  });
});