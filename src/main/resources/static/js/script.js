// Form validation for the Add Expense form
document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const amountInput = document.querySelector("#amount");
    const descriptionInput = document.querySelector("#description");
    const categoryInput = document.querySelector("#category");

    form.addEventListener("submit", function (event) {
        let isValid = true;

        // Validate amount (should be a positive number)
        if (parseInt(amountInput.value) <= 0 || isNaN(parseInt(amountInput.value))) {
            alert("Amount must be a positive number!");
            isValid = false;
        }

        // Validate description (cannot be empty)
        if (descriptionInput.value.trim() === "") {
            alert("Description cannot be empty!");
            isValid = false;
        }

        // Validate category (cannot be empty)
        if (categoryInput.value.trim() === "") {
            alert("Category cannot be empty!");
            isValid = false;
        }

        if (!isValid) {
            event.preventDefault(); // Stop form submission if validation fails
        }
    });
});