window.addEventListener('DOMContentLoaded', function() {
    const swiper = new Swiper(".mySwiper", {
        pagination: {
            el: ".swiper-pagination",
            clickable: true,
            renderBullet: function (index, className) {
                const btnName = [];
                btnName[0] = "TOP 10"
                btnName[1] = "MD 추천"

                return '<span class="' + className + '">' + (btnName[index]) + "</span>";
            },
        },
    });

    function checkSelectAll()  {
        // 전체 체크박스
        const checkboxes
            = document.querySelectorAll('input[name="agree"]');
        // 선택된 체크박스
        const checked
            = document.querySelectorAll('input[name="agree"]:checked');
        // select all 체크박스
        const selectAll
            = document.querySelector('input[name="selectall"]');

        if(checkboxes.length === checked.length)  {
            selectAll.checked = true;
        }else {
            selectAll.checked = false;
        }

    }

    function selectAll(selectAll)  {
        const checkboxes
            = document.getElementsByName('agree');

        checkboxes.forEach((checkbox) => {
            checkbox.checked = selectAll.checked
        })
    }
});