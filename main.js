// Inisialisasi file efek suara
const loadingSound = new Audio('loading.mp3');

// Fungsi untuk memutar audio saat ada interaksi pertama
function playAudioOnInteraction() {
    loadingSound.play().catch(err => console.log('Audio gagal diputar:', err));
    // Hapus event listener setelah audio diputar sekali
    window.removeEventListener('click', playAudioOnInteraction);
    window.removeEventListener('keydown', playAudioOnInteraction);
}

// Logika Loading Screen Utama
window.addEventListener('DOMContentLoaded', () => {
    const loadingScreen = document.getElementById('loadingScreen');
    
    // Coba putar otomatis langsung
    loadingSound.play().catch(() => {
        // Jika diblokir browser, tunggu klik/tombol dari user
        window.addEventListener('click', playAudioOnInteraction);
        window.addEventListener('keydown', playAudioOnInteraction);
    });

    if (loadingScreen && sessionStorage.getItem('skipLoading') === 'true') {
        loadingScreen.style.display = 'none';
        sessionStorage.removeItem('skipLoading');
    } else if (loadingScreen) {
        setTimeout(() => {
            loadingScreen.classList.add('fade-out');
        }, 5000);
    }
});

// Logika untuk Menu Hamburger Buka/Tutup
const hamburgerMenu = document.getElementById('hamburgerMenu');
const sideMenu = document.getElementById('sideMenu');
const closeMenu = document.getElementById('closeMenu');

if (hamburgerMenu && sideMenu) {
    hamburgerMenu.addEventListener('click', () => {
        sideMenu.classList.add('active');
    });
}

if (closeMenu && sideMenu) {
    closeMenu.addEventListener('click', () => {
        sideMenu.classList.remove('active');
    });
}

// Generator Efek Jaringan (Network Nodes) untuk Side Menu
const particlesContainer = document.getElementById('menuParticles');
if (particlesContainer) {
    particlesContainer.innerHTML = '';
    const nodeCount = 12;

    for (let i = 0; i < nodeCount; i++) {
        const node = document.createElement('div');
        node.classList.add('network-node');
        
        const size = Math.random() * 3 + 3;
        node.style.width = `${size}px`;
        node.style.height = `${size}px`;
        
        const posX = Math.random() * 90 + 5;
        node.style.top = `${Math.random() * 90 + 5}%`;
        node.style.left = `${posX}%`;
        
        const duration = Math.random() * 4 + 3;
        node.style.animationDuration = `${duration}s`;
        
        particlesContainer.appendChild(node);
    }
}

// Logika Terjemahan Bahasa (ID / EN)
const translations = {
    id: {
        heroBadge: "#1 Internet Rumah Terbaik",
        brand: "GoldenLink",
        title: "Internet Unlimited<br>Bebas FUP & Lag",
        subtitle: "Streaming 4K lancar, main game tanpa ping merah. Nikmati koneksi internet stabil tanpa kuota untuk seluruh keluarga.",
        sectionTitle: "Pilihan Paket Langganan!",
        badge: "Internet Only",
        pkgBasic: "Paket Basic",
        pkgStandard: "Paket Standard",
        pkgExecutive: "Paket Executive",
        pkgUltimate: "Paket Ultimate",
        ppn: "Harga Sudah Termasuk PPN",
        fup: "Unlimited Tanpa FUP",
        pasang: "Gratis Biaya Pasang",
        streaming: "Bisa Streaming HD & Game",
        zoom: "Lancar Zoom & Game Online",
        cs: "Prioritas Layanan CS",
        devBasic: "Ideal untuk 1-5 perangkat",
        devStandard: "Ideal untuk 6-10 perangkat",
        devExecutive: "Ideal untuk 10-14 perangkat",
        devUltimate: "Ideal untuk 15+ perangkat",
        priceLabel: "Harga Langganan",
        perMonth: "/bln",
        footer: "© 2026 GoldenLink. Hubungi Layanan Pelanggan: 0858-1483-7353",
        menuHome: "Beranda",
        menuAbout: "Tentang",
        aboutTitle: "Tentang GoldenLink",
        aboutDesc: "Kami adalah penyedia layanan internet rumah terbaik yang berkomitmen menghadirkan koneksi super cepat, stabil tanpa batas FUP, dan dukungan penuh untuk seluruh anggota keluarga."
    },
    en: {
        heroBadge: "#1 Best Home Internet",
        brand: "GoldenLink",
        title: "Unlimited Internet<br>No FUP & Zero Lag",
        subtitle: "Smooth 4K streaming, low ping gaming. Enjoy stable internet connection without quota for the whole family.",
        sectionTitle: "Subscription Package Options!",
        badge: "Internet Only",
        pkgBasic: "Basic Package",
        pkgStandard: "Standard Package",
        pkgExecutive: "Executive Package",
        pkgUltimate: "Ultimate Package",
        ppn: "Price Includes VAT",
        fup: "Unlimited Without FUP",
        pasang: "Free Installation Fee",
        streaming: "HD Streaming & Gaming Ready",
        zoom: "Smooth Zoom & Online Gaming",
        cs: "Priority CS Support",
        devBasic: "Ideal for 1-5 devices",
        devStandard: "Ideal for 6-10 devices",
        devExecutive: "Ideal for 10-14 devices",
        devUltimate: "Ideal for 15+ devices",
        priceLabel: "Subscription Price",
        perMonth: "/mo",
        footer: "© 2026 GoldenLink. Contact Customer Service: 0858-1483-7353",
        menuHome: "Home",
        menuAbout: "About",
        aboutTitle: "About GoldenLink",
        aboutDesc: "We are the best home internet service provider committed to delivering super fast connections, unlimited FUP, and full support for the whole family."
    }
};

const langSelect = document.getElementById('languageSelect');
if (langSelect) {
    langSelect.addEventListener('change', function() {
        const lang = this.value;
        const t = translations[lang];

        if (document.getElementById('heroBadge')) document.getElementById('heroBadge').textContent = t.heroBadge;
        if (document.querySelector('.brand-name')) document.querySelector('.brand-name').textContent = t.brand;
        if (document.querySelector('.hero-title')) document.querySelector('.hero-title').innerHTML = t.title || t.aboutTitle;
        if (document.querySelector('.hero-subtitle')) document.querySelector('.hero-subtitle').textContent = t.subtitle || t.aboutDesc;
        if (document.getElementById('aboutTitle')) document.getElementById('aboutTitle').textContent = t.aboutTitle;
        if (document.getElementById('aboutDesc')) document.getElementById('aboutDesc').textContent = t.aboutDesc;
        if (document.querySelector('.section-title')) document.querySelector('.section-title').textContent = t.sectionTitle;
        if (document.getElementById('menuHome')) document.getElementById('menuHome').textContent = t.menuHome;
        if (document.getElementById('menuAbout')) document.getElementById('menuAbout').textContent = t.menuAbout;

        document.querySelectorAll('.
