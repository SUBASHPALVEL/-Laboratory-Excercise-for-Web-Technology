document.addEventListener("DOMContentLoaded", function() {
    var navLinks = document.querySelectorAll("nav ul li a");
    var sections = document.querySelectorAll("section");

    for (var i = 0; i < navLinks.length; i++) {
        navLinks[i].addEventListener("click", function(e) {
            e.preventDefault();
            var target = this.getAttribute("href").substring(1);
            showSection(target);
        });
    }

    function showSection(id) {
        for (var i = 0; i < sections.length; i++) {
            sections[i].style.display = "none";
        }
        document.getElementById(id).style.display = "block";
    }
});
