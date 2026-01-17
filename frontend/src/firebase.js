import { initializeApp } from "firebase/app";
import { initializeFirestore } from "firebase/firestore";

// 👇 PUNE DATELE REALE AICI (doar pentru test)
const firebaseConfig = {
  apiKey: "AIzaSyBmIWCyhJNDmbHVI9KRiRWIhlJR88N4MJA",
  authDomain: "shop-chat-678c5.firebaseapp.com",
  projectId: "shop-chat-678c5",
  storageBucket: "shop-chat-678c5.firebasestorage.app",
  messagingSenderId: "597919492495",
  appId: "1:597919492495:web:adb31d4ab73a2a236bc3fa"
};
const app = initializeApp(firebaseConfig);

// Păstrăm setarea pentru conexiune stabilă
export const db = initializeFirestore(app, {
    experimentalForceLongPolling: true,
});

console.log("Firebase conectat la proiectul:", firebaseConfig.projectId);