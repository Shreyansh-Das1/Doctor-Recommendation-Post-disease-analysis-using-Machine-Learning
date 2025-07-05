// Smooth scroll for navigation links
const navLinks = document.querySelectorAll('nav ul li a');
navLinks.forEach(link => {
  link.addEventListener('click', function(e) {
    const href = this.getAttribute('href');
    if (href.startsWith('#')) {
      e.preventDefault();
      document.querySelector(href).scrollIntoView({ behavior: 'smooth' });
    }
  });
});

// Register button scrolls to registration section
const regBtn = document.querySelector('.registerbutton');
if (regBtn) {
  regBtn.addEventListener('click', function(e) {
    e.preventDefault();
    const regSection = document.querySelector('#register');
    if (regSection) {
      regSection.scrollIntoView({ behavior: 'smooth' });
    }
  });
}

// Contact form validation and confirmation
const contactForm = document.querySelector('.contact-section form');
if (contactForm) {
  contactForm.addEventListener('submit', function(e) {
    e.preventDefault();
    const name = contactForm.querySelector('input[type="text"]').value.trim();
    const email = contactForm.querySelector('input[type="email"]').value.trim();
    const message = contactForm.querySelector('textarea').value.trim();
    if (!name || !email || !message) {
      alert('Please fill in all fields.');
      return;
    }
    // Simple email validation
    if (!/^[^@\s]+@[^@\s]+\.[^@\s]+$/.test(email)) {
      alert('Please enter a valid email address.');
      return;
    }
    // Show confirmation
    contactForm.reset();
    alert('Thank you for contacting us! We will get back to you soon.');
  });
}

// Highlight nav link on scroll
const sections = document.querySelectorAll('section');
window.addEventListener('scroll', () => {
  let current = '';
  sections.forEach(section => {
    const sectionTop = section.offsetTop - 80;
    if (pageYOffset >= sectionTop) {
      current = section.getAttribute('id');
    }
  });
  navLinks.forEach(link => {
    link.classList.remove('active');
    if (link.getAttribute('href') === `#${current}`) {
      link.classList.add('active');
    }
  });
}); 