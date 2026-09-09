<script>
    // Logika Loading Screen Utama (Akses Normal / Refresh)
    window.addEventListener('DOMContentLoaded', () => {
        const loadingScreen = document.getElementById('loadingScreen');
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
            const posY = Math.random() * 90 + 5;
            node.style.left = `${posX}%`;
            node.style.top = `${posY}%`;
            
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

            document.querySelectorAll('.badge').forEach(el => el.textContent = t.badge);
            document.querySelectorAll('.price-label').forEach(el => el.textContent = t.priceLabel);
            document.querySelectorAll('.price span').forEach(el => el.textContent = t.perMonth);

            const pkgNames = document.querySelectorAll('.package-name');
            if (pkgNames.length >= 4) {
                pkgNames[0].textContent = t.pkgBasic;
                pkgNames[1].textContent = t.pkgStandard;
                pkgNames[2].textContent = t.pkgExecutive;
                pkgNames[3].textContent = t.pkgUltimate;
            }

            const cards = document.querySelectorAll('.card');
            if (cards.length >= 4) {
                cards[0].querySelectorAll('.features li')[0].innerHTML = `<span class="check">✓</span> ${t.ppn}`;
                cards[0].querySelectorAll('.features li')[1].innerHTML = `<span class="check">✓</span> ${t.devBasic}`;
                cards[0].querySelectorAll('.features li')[2].innerHTML = `<span class="check">✓</span> ${t.fup}`;
                cards[0].querySelectorAll('.features li')[3].innerHTML = `<span class="check">✓</span> ${t.pasang}`;

                cards[1].querySelectorAll('.features li')[0].innerHTML = `<span class="check">✓</span> ${t.ppn}`;
                cards[1].querySelectorAll('.features li')[1].innerHTML = `<span class="check">✓</span> ${t.devStandard}`;
                cards[1].querySelectorAll('.features li')[2].innerHTML = `<span class="check">✓</span> ${t.fup}`;
                cards[1].querySelectorAll('.features li')[3].innerHTML = `<span class="check">✓</span> ${t.streaming}`;

                cards[2].querySelectorAll('.features li')[0].innerHTML = `<span class="check">✓</span> ${t.ppn}`;
                cards[2].querySelectorAll('.features li')[1].innerHTML = `<span class="check">✓</span> ${t.devExecutive}`;
                cards[2].querySelectorAll('.features li')[2].innerHTML = `<span class="check">✓</span> ${t.fup}`;
                cards[2].querySelectorAll('.features li')[3].innerHTML = `<span class="check">✓</span> ${t.zoom}`;

                cards[3].querySelectorAll('.features li')[0].innerHTML = `<span class="check">✓</span> ${t.ppn}`;
                cards[3].querySelectorAll('.features li')[1].innerHTML = `<span class="check">✓</span> ${t.devUltimate}`;
                cards[3].querySelectorAll('.features li')[2].innerHTML = `<span class="check">✓</span> ${t.fup}`;
                cards[3].querySelectorAll('.features li')[3].innerHTML = `<span class="check">✓</span> ${t.cs}`;
            }

            if (document.querySelector('footer p')) document.querySelector('footer p').textContent = t.footer;
        });
    }
</script>
