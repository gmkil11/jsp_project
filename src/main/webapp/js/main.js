
const swiper = new Swiper(".mySwiper", {
    speed : 800,
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

