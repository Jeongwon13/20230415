const boardFormbtn = document.getElementsByClassName("click", function() {
     if (loginMember) {
    window.location.href = "/board/boardForm";
  } else {
    // 로그인 정보가 없는 경우 권한 없음 알림 표시
    alert("로그인이 필요합니다.");
  }
});

