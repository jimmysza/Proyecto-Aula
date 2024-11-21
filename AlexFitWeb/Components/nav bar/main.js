const checkbox = document.querySelector(".header__checkbox");
const checkboxClose = document.querySelector(".icon-close");
const navBox = document.querySelector(".header-nav");

checkbox.addEventListener("click", () => {
  navBox.classList.toggle("hidden");
});

checkboxClose.addEventListener("click", () => {
  navBox.classList.toggle("hidden");
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