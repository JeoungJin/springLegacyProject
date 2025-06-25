<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
  <title>카드 등록</title>
  <script src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
  <h3>카드 등록 테스트</h3>
  <button onclick="requestCard()">카드 등록하기</button>

  <script>
    const IMP = window.IMP;
    IMP.init("imp10391932"); // 아임포트 테스트   본인 가맹점 식별코드

    function requestCard() {
      IMP.request_pay({
        pg: "nice",    //이니시스html5_inicis  , 토스페이먼츠tosspay
        pay_method: "card",
        customer_uid: "user_1001_card1",
        name: "카드 등록",
        amount: 0
      }, function (rsp) {
        if (rsp.success) {
          fetch("/payment/saveCard.do", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
              userId: "user_1001",
              customerUid: rsp.customer_uid
            })
          }).then(res => res.text()).then(alert);
        } else {
          alert("실패: " + rsp.error_msg);
        }
      });
    }
  </script>
</body>
</html>
