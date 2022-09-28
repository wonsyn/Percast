<template>
  <div id="board-container" class="container mt-5">
    <strong class="percast-font" style="font-size: 50px">QnA</strong>
    <div class="pt-5 pb-3 d-flex">
      <button class="btn btn-success mx-3" style="width: 100px">QnA</button
      ><button class="btn btn-info" style="width: 100px">공지사항</button>
      <div class="me-auto"></div>
      <button class="btn btn-success me-3">글 작성</button>
    </div>
    <div class="pb-3">
      <table class="table percast-font">
        <thead>
          <tr class="bg-info">
            <th scope="col-3">글 번호</th>
            <th scope="col-6">제목</th>
            <th scope="col-3">작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry the Bird</td>
            <td>@twitter</td>
          </tr>
        </tbody>
      </table>
      <div class="d-flex">
        <img class="me-2" src="@/assets/left.png" />
        <div class="percast-font">1 2 3</div>
        <img class="ms-2" src="@/assets/right.png" />
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
