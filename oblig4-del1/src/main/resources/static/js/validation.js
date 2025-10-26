document.addEventListener("DOMContentLoaded", () => {
  // --- Automatisk stor bokstav (inkl. ÆØÅ) ---
  function formaterNavn(navn) {
    if (!navn) return "";
    // Gjør første bokstav i hvert ord UpperCase
    return navn.replace(/(^|\s|-)(\p{L})/gu, (_, sep, bokstav) => sep + bokstav.toUpperCase());
  }

  ["fornavn", "etternavn"].forEach((felt) => {
    const input = document.querySelector(`input[name="${felt}"]`);
    if (input) {
      input.addEventListener("input", () => {
        const start = input.selectionStart;
        input.value = formaterNavn(input.value);
        input.setSelectionRange(start, start);
      });
    }
  });

  // --- Valider passord ---
  const form = document.querySelector("form");
  form.addEventListener("submit", (e) => {
    const pass = document.querySelector('input[name="passord"]').value;
    const repass = document.querySelector('input[name="repeterPassord"]').value;
    if (pass !== repass) {
      e.preventDefault();
      alert("Passordene stemmer ikke overens!");
    }
  });
});
