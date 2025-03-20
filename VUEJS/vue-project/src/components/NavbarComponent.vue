<template>
  <nav class="nav">
    <a class="nav-link left-text disabled" href="#">ELC</a>
    <a class="nav-link central-text" href="http://localhost:5173/">VUEJS</a>
  </nav>
</template>

<script>
export default {
  name: 'NavbarComponent' // 올바른 export default 구문
}
</script>

<style>
.nav {
  display: flex;
  justify-content: space-between; /* 양쪽 끝으로 정렬 */
  align-items: center; /* 수직 중앙 정렬 */
  height: 60px; /* 네비게이션 바의 높이 설정 */
  width:100vw;
  padding: 0 20px; /* 좌우 패딩 추가 */
  background-color: #9FB6D8; /* 배경색 설정 */
  position: fixed; /* 고정 위치 설정 */
  top: 0; /* 상단에 고정 */
  left: 0; /* 왼쪽에 고정 */
  z-index: 1000; /* 다른 요소 위에 표시되도록 설정 */
}

.left-text {
  margin-right: auto; /* 왼쪽 텍스트에 자동 마진 추가하여 왼쪽 정렬 */
  font-weight:bold;
}

.central-text {
  position: absolute; /* 절대 위치 지정 */
  left: 50%; /* 중앙에 위치 */
  transform: translateX(-50%); /* 중앙 정렬을 위한 변환 */
  font-weight: bold; /* 텍스트 강조 */
  font-size: 30px;
}
</style>

