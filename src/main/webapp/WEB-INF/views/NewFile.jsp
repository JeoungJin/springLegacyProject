<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>음성인식 예제</title>
</head>
<body>
  <h1>🎤 음성 인식 예제</h1>
  <button id="startBtn">음성인식 시작</button>
  <p id="result">여기에 음성 결과가 표시됩니다.</p>

  <script>
    // 브라우저 호환성 처리
    const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;

    if (!SpeechRecognition) {
      alert("이 브라우저는 음성 인식을 지원하지 않습니다.");
    } else {
      const recognition = new SpeechRecognition();
      recognition.lang = 'ko-KR';       // 한국어
      recognition.interimResults = false;
      recognition.maxAlternatives = 1;

      const resultBox = document.getElementById("result");
      const startBtn = document.getElementById("startBtn");

      startBtn.onclick = () => {
        recognition.start();
        resultBox.textContent = "🎙️ 말해주세요...";
      };

      recognition.onresult = (event) => {
        const transcript = event.results[0][0].transcript;
        resultBox.textContent = "📝 인식된 음성: " + transcript;
        console.log("Confidence: " + event.results[0][0].confidence);
      };

      recognition.onspeechend = () => {
        recognition.stop();
      };

      recognition.onerror = (event) => {
        resultBox.textContent = '❗ 오류: ' + event.error;
      };
    }
  </script>
</body>
</html>
