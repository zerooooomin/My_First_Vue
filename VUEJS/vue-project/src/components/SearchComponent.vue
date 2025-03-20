<template>
    <nav class="navbar">
      <div class="container-fluid justify-content-center"> <!-- 중앙 정렬을 위한 클래스 추가 -->
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">🔍</button>
        </form>
      </div>
    </nav>
  </template>
  
  <script>
  export default {
    name: 'SearchComponent'
  }
  </script>
  
  <style>
  .navbar {
    display: flex;
    justify-content: space-between; /* 양쪽 끝으로 정렬 */
    align-items: center; /* 수직 중앙 정렬 */
    height: 60px; /* 네비게이션 바의 높이 설정 */
    width:100vw;
    padding: 0 20px; /* 좌우 패딩 추가 */
    background-color: #ffffff; /* 배경색 설정 */
    position: fixed; /* 고정 위치 설정 */
    top: 60px; /* 상단에 고정 */
    left: 0; /* 왼쪽에 고정 */
  }
  
  .container-fluid {
    display: flex; /* Flexbox 사용 */
    justify-content: center; /* 중앙 정렬 */
  }
  </style>
  