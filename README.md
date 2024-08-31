# Mart.ps App Improvement Project
## Project Overview
## Project Name
### Mart.ps App Improvement
### team6
## Project Description
This project focuses on improving the components of the Mart.ps mobile application, a leading online sales platform in Palestine. The website offers a wide range of products including clothes, jewelry, shoes, household items, etc.
We aimed to enhance the user experience by improving critical components such as the login and sign-up pages and the product search results page. We aimed to align our improvements with the existing design identity of Mart.ps while optimizing functionality.
## Project Goals
* **Improve User Experience**: Enhance the usability of key components like login, sign-up, and search results pages.
* **Preserve Brand Identity**: Maintain the existing visual identity of Mart.ps while introducing modern design improvements.
* **Optimize Performance**: Ensure that all enhancements contribute to the overall performance and responsiveness of the application.
* **Collaborative Development**: Use a micro-frontend architecture for parallel development and easier maintenance.
## System Design Architecture Diagram
# Draw High-Level Design Architecture
# 1. Microservices Architecture
![Component-architecture6](https://github.com/user-attachments/assets/2a2a2780-179d-4ff3-97c2-4d083f1289c8)
# 2. Event-driven Architecture
![Component-architecture5](https://github.com/user-attachments/assets/4a530815-aca0-44a6-8752-753cbe5016fa)
# 3. Microservicses flow:
![Component-architecture1](https://github.com/user-attachments/assets/fac13ef4-93a8-4644-8b35-36351a50a2c5)
![Component-architecture2](https://github.com/user-attachments/assets/4236eba4-3ab5-47a9-b209-9ccc54f169b2)
![Component-architecture3](https://github.com/user-attachments/assets/d9275906-7b34-408d-936a-cb110e7c3056)
![Component-architecture4](https://github.com/user-attachments/assets/89342ee6-b04b-4065-a509-a77c55974764)

## Figma Design File
In this project, we focused on redesigning the Mart.ps app to enhance the user experience while preserving the original identity and branding of the website. We used the same website colors
The redesign included improvements to the user interface (UI) and use experience (UX) components, such as the login and sign-up pages, and the product search results page.

You can view our Figma design file here: [Figma File - Mart.ps App Improvement](https://www.figma.com/design/mGgneQ0Bac1BMedANecQBM/Mart.ps?node-id=69-331&t=largrcf6YktiizV6-1).

## 🧩 Microfrontend Architecture: Kotlin and Flutter
The chosen microfrontend architecture combines Kotlin and Flutter to leverage their respective strengths in mobile development.

- **Kotlin** is used for native Android components, providing seamless integration with Android and strong performance.
- **Flutter** is utilized for developing other components of the application, offering cross-platform capabilities and rich UI/UX features.

This architecture enables modular and scalable development, allowing teams to work independently on different parts of the application. This promotes rapid development and simplifies maintenance.

## 🔗 Communication Model: Publish-Subscribe (Pub-Sub) Pattern
The communication between microfrontends is managed through a Publish-Subscribe (Pub-Sub) pattern using communication channels.

- **Publisher:** A component that sends messages on specific topics without knowing which components will receive them.
- **Subscriber:** Components that listen for relevant messages and react accordingly.

This model decouples the components, ensuring that changes in one part of the application do not directly affect others. It enhances the robustness of the system and facilitates easy scaling or modifications.

## 🚀 Deployment Strategy: Integration via APK
Microfrontends are deployed and integrated into the main application through APK files.

- Each microfrontend is developed, tested, and packaged as a separate module.
- These modules are then combined into a single APK during the build process.

This strategy allows each microfrontend to be updated independently, eliminating the need for a complete rebuild of the entire application. This approach speeds up the release cycle and simplifies the deployment process.
