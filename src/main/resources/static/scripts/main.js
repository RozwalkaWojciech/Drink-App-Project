let elem = document.querySelector('.quotes-wrapper');
let flkty = new Flickity(elem, {
    cellAlign: 'center',
    contain: true
});

(function () {
    'use strict';

    let navSelector = '.navigation';
    let linksSelector = '.navigation a';
    let scrollSpeed = 60;

    let timer, targetPosition;

    function scroll() {
        let delta = targetPosition - document.documentElement.scrollTop;
        if (delta > 0) {
            document.documentElement.scrollTop += Math.min(delta, scrollSpeed);
        } else if (delta < 0) {
            document.documentElement.scrollTop += Math.max(delta, -scrollSpeed);
        } else {
            clearInterval(timer);
        }

        if (window.innerHeight >= document.documentElement.scrollHeight - document.documentElement.scrollTop) {
            clearInterval(timer);
        }
    }

    let onLinkClick = function (event) {
        event.preventDefault();
        clearInterval(timer)

        let navHeight = document.querySelector(navSelector).offsetHeight;
        let target = document.querySelector(this.getAttribute('href'));
        if (target) {
            targetPosition = Math.max(0, target.offsetTop - navHeight);
            scroll();
            timer = setInterval(scroll, 1000 / 30);
        }
    };

    let links = document.querySelectorAll(linksSelector);

    for (let i = 0; i < links.length; i++) {
        links[i].addEventListener('click', onLinkClick);
    }

})();
