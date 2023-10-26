function toggleAll(checkbox) {
    const checkboxes = document.querySelectorAll('.agree');

    checkboxes.forEach((box) => {
        box.checked = checkbox.checked;
    });
}

function checkSelectAll() {
    const checkboxAge = document.getElementsByName('ageAgree');
    const checkboxTerm = document.getElementsByName('termsOfUser');
    const checkboxPri = document.getElementsByName('privacy');
    const checkboxThird = document.getElementsByName('thirdPartyAgree');
    const selectAll = document.getElementById('selectAll');

    const allCheckboxes = [...checkboxAge, ...checkboxTerm, ...checkboxPri, ...checkboxThird];
    let allChecked = true;

    for (const checkbox of allCheckboxes) {
        if (!checkbox.checked) {
            allChecked = false;
            break;
        }
    }

    selectAll.checked = allChecked;
}
