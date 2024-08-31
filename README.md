# 🌟 Mart.ps App Improvement Project

## 🗂 Project Overview

### 📛 Project Name
#### Mart.ps App Improvement
#### team6

### 📋 Project Description

This project focuses on improving the components of the Mart.ps mobile application, a leading online sales platform in Palestine. The website offers a wide range of products including clothes, jewelry, shoes, household items, etc.
We aimed to enhance the user experience by improving critical components such as the login and sign-up pages and the product search results page. We aimed to align our improvements with the existing design identity of Mart.ps while optimizing functionality.
## 🎯 Project Goals
* **Improve User Experience**: Enhance the usability of key components like login, sign-up, and search results pages.
* **Preserve Brand Identity**: Maintain the existing visual identity of Mart.ps while introducing modern design improvements.
* **Optimize Performance**: Ensure that all enhancements contribute to the overall performance and responsiveness of the application.
* **Collaborative Development**: Use a micro-frontend architecture for parallel development and easier maintenance.
## 🏛 System Design Architecture Diagram
# ✏️ Draw High-Level Design Architecture
# 1. Microservices Architecture
![Component-architecture6](https://github.com/user-attachments/assets/2a2a2780-179d-4ff3-97c2-4d083f1289c8)
# 2. Event-driven Architecture
![Component-architecture5](https://github.com/user-attachments/assets/4a530815-aca0-44a6-8752-753cbe5016fa)

## 🎨 Figma Design File
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
Microfrontends are deployed and integrated into the main application through a single APK file.

- All microfrontends are developed, tested, and integrated together within the main application.
- During the build process, these components are combined and packaged into a single APK, ensuring a seamless and unified application experience for users.

This strategy allows each microfrontend to be updated independently, eliminating the need for a complete rebuild of the entire application. This approach speeds up the release cycle and simplifies the deployment process.

## 🔧 Integration Approach

### Integration Method
The chosen method for integrating microfrontends in the Mart.ps mobile application involves modular assembly using APK files. Each microfrontend is developed as an independent module, which is then integrated into the main application during the build process. This approach allows for the combination of native Android components written in Kotlin and cross-platform components developed in Flutter, ensuring seamless interaction within the application.

### Integration Points
The specific points of integration within the main application include:

- **User Interface Components:** Integration of UI elements such as login, sign-up, and product search results pages, ensuring a consistent design language across microfrontends.
- **Shared Services:** Integration of shared services like authentication, data fetching, and state management to maintain coherence in user interactions across different parts of the application.
- **Navigation:** Seamless navigation between microfrontends is managed to provide a unified user experience, leveraging Flutter's Navigator and Kotlin's native navigation components.

### Integration Challenges
While integrating microfrontends, several challenges may arise:

1. **Inconsistent Design Language:** Ensuring a cohesive look and feel across components developed in Kotlin and Flutter can be challenging.  
   **Solution:** Establish a unified design system with shared styles and components to maintain visual consistency.

2. **Performance Overhead:** Combining different frameworks may introduce performance overhead, affecting the app's responsiveness.  
   **Solution:** Optimize performance by minimizing communication overhead between microfrontends and using lightweight data exchange formats.

By addressing these challenges with strategic solutions, the integration of microfrontends can enhance the Mart.ps mobile application's modularity and maintainability while providing a seamless user experience.
.
## 🚀 Deployment

### Deployment Process
The deployment of the Mart.ps microfrontend application follows a streamlined process to ensure efficient integration and release:

1. **Build Process:** The entire application, including all microfrontends developed in Kotlin and Flutter, is built together using Gradle. This unified build process ensures that all components are compiled and packaged simultaneously, maintaining compatibility and reducing complexity.

2. **Integration:** Microfrontends are integrated directly within the main application as part of the single APK build. This approach ensures that all components are seamlessly combined into one cohesive application without the need for independent modules.

3. **Testing:** The integrated APK undergoes testing, including UI tests, to verify that all features work as expected across the entire application.

5. **Release:** The finalized APK is deployed directly to the production environment. This ensures that users receive a single, consistent application experience with each update.

### Deployment Environment
- **Production Environment:** The single deployment environment where the application is made available to end-users. This environment requires the highest level of stability and security to ensure a reliable and seamless user experience.

### Deployment Tool
- **Gradle:** The primary tool used for building, integrating, and managing dependencies of all microfrontends. Gradle handles the entire process from compiling the source code to packaging the final APK, ensuring a smooth and efficient deployment pipeline.


## 🏁 Getting Started

### Prerequisites
Before you begin, ensure you have the following software and tools installed:

- **Flutter SDK**: [Flutter Installation Guide](https://flutter.dev/docs/get-started/install)
- **Kotlin**: [Kotlin Setup](https://kotlinlang.org/docs/tutorials/getting-started.html)
- **Android Studio**: For Android development [Download Android Studio](https://developer.android.com/studio)

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/CBSE-summer2024/team6.git
   
2. **Install Dependencies**
- For Flutter:
  ```bash
   flutter pub get
- For Kotlin: Open the project in Android Studio and sync the Gradle files.

3. **Running the Project**
- Start the Flutter Application
   ```bash
   flutter run
  
- Build the Kotlin Components Use Android Studio to run or debug the native Android modules.

## 🛠 Development Workflow
**Development Tools**
- **Flutter**: For developing cross-platform components.
- **Kotlin**: For native Android components.
- **Gradle**: For build automation.
- **Git**: For version control.


## 📚 Resources

### Deployment Guides
- **Deploying Flutter Apps Across Platforms:** A comprehensive guide to deploying Flutter applications on iOS, Android, and the web.  
  [Read the full article here](https://medium.com/@chetan.akarte/how-do-you-deploy-flutter-apps-to-different-platforms-ios-android-web-511b65f4388a#:~:text=To%20deploy%20a%20Flutter%20app%20to%20the%20web%2C%20you%20need,flutter%20config%20%E2%80%94%20enable%2Dweb.&text=%C2%B7-,Open%20your%20Flutter%20project%20in%20a%20terminal%20and%20run%20flutter,web%20version%20of%20your%20app.)


## 📱 Screen Shots
<img width="329" alt="Screenshot 2024-08-31 at 15 34 44" src="https://github.com/user-attachments/assets/385b4446-95b0-48cc-9c10-dd354a57ee26">
<img width="333" alt="Screenshot 2024-08-31 at 15 35 01" src="https://github.com/user-attachments/assets/52580d4c-33a3-4e1d-971d-9f3d139d2998">
<img width="326" alt="Screenshot 2024-08-31 at 15 35 32" src="https://github.com/user-attachments/assets/7e52dd0c-1fd2-4be7-8772-e49066b8492b">
<img width="329" alt="Screenshot 2024-08-31 at 15 35 48" src="https://github.com/user-attachments/assets/48010e28-ec2f-4d3f-8235-3838a36ce060">
<img width="332" alt="Screenshot 2024-08-31 at 15 37 16" src="https://github.com/user-attachments/assets/5015e105-2ae4-4517-8b00-19c460dc1229">
<img width="332" alt="Screenshot 2024-08-31 at 15 37 37" src="https://github.com/user-attachments/assets/bfc01a22-9604-4cf8-b037-96f2d7b230c2">
<img width="330" alt="Screenshot 2024-08-31 at 15 37 53" src="https://github.com/user-attachments/assets/b76b3e1e-e2ff-4c66-97f3-2cc1d2bbfac0">
