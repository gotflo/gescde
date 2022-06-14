function myFun() {
  alert("Test Js");
}

function isEmpty() {
  let numeroBeneficiaire = document.getElementById("numeroBeneficiaire").value;
  let lastNameChild = document.getElementById("lastNameChild").value;
  let numeroParrain = document.getElementById("numeroParrain").value;
  let parrainName = document.getElementById("parrainName").value;
  let firstNameChild = document.getElementById("firstNameChild").value;

  if (
    numeroBeneficiaire !== "" &&
    lastNameChild !== "" &&
    numeroParrain !== "" &&
    parrainName !== "" &&
    firstNameChild !== ""
  ) {
    document.getElementById("btnChildSave").removeAttribute("disabled");
  } else if (
    numeroBeneficiaire === "" ||
    lastNameChild === "" ||
    numeroParrain === "" ||
    parrainName === "" ||
    firstNameChild === ""
  ) {
    document.getElementById("btnChildSave").setAttribute("disabled", "");
  }
}

// function isEmpty() {
//   const numeroBeneficiaire = document.getElementById("numeroBeneficiaire");
//   const lastNameChild = document.getElementById("lastNameChild");
//   const btnChildSave = document.getElementById("btnChildSave");

//   numeroBeneficiaire.addEventListener("keyup", (e) => {
//     const value = e.currentTarget.value;
//     if (value === "") {
//       btnChildSave.disabled = true;
//     } else {
//       btnChildSave.disabled = false;
//     }
//   });
// }
