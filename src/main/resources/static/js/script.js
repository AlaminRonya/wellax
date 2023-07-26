function toggleLoginPopup() {
    var loginPopupContainer = document.querySelector(".loginPageContainer");
    loginPopupContainer.style.display = loginPopupContainer.style.display === "none" ? "block" : "none";
}


// Get all menu items in both navigation bars
const coreServicesMenuItems = document.querySelectorAll('.core-services li');
const healthServicesMenuItems = document.querySelectorAll('.health-services li');

// Function to handle menu item click and redirection
function handleMenuItemClick(menuItems) {
    menuItems.forEach((item) => {
        item.addEventListener('click', () => {
            // Remove the 'selected' class from all menu items
            menuItems.forEach((item) => {
                item.classList.remove('selected');
            });
            // Add the 'selected' class to the clicked menu item
            item.classList.add('selected');

            // Perform redirection based on the menu item's text
            const menuItemText = item.textContent.trim();
            switch (menuItemText) {
                case 'Core Services':
                    window.location.href = 'core-services.html';
                    break;
                case 'Guide Services':
                    window.location.href = 'guide-services.html';
                    break;
                case 'Home Care Services':
                    window.location.href = 'home-care-services.html';
                    break;
                case 'Doctor':
                    window.location.href = 'doctor.html';
                    break;
                case 'Hospital':
                    window.location.href = 'hospital.html';
                    break;
                case 'Diagnostic':
                    window.location.href = 'diagnostic.html';
                    break;
                case 'Pharmacy and Store':
                    window.location.href = 'pharmacy-and-store.html';
                    break;
                // Add more cases for other menu items and corresponding page URLs
                default:
                    break;
            }
        });
    });
}

// Call the function for both navigation menus
handleMenuItemClick(coreServicesMenuItems);
handleMenuItemClick(healthServicesMenuItems)