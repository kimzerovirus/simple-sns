<template>
	<div class="d-flex align-items-center">
		<div class="container">
			<div class="row d-flex justify-content-center align-items-center">
				<div class="col-12 col-md-9 col-lg-7 col-xl-6">
					<div class="card-body p-5">
						<h2 class="text-uppercase text-center mb-5">회원 가입</h2>

						<form>
							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example1cg">닉네임</label>
								<input type="text" id="form3Example1cg" class="form-control form-control-lg" />
								<span class="text-danger text-small">이미 사용중이거나 탈퇴한 닉네임입니다.</span>
								<span class="text-danger text-small">필수 정보입니다.</span>
							</div>

							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example3cg">이메일</label>
								<input type="email" id="form3Example3cg" class="form-control form-control-lg" />
								<span class="text-danger text-small">이미 사용중이거나 탈퇴한 이메일입니다. </span>
								<span class="text-danger text-small">필수 정보입니다.</span>
							</div>

							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example4cg">비밀번호</label>
								<input type="password" id="form3Example4cg" class="form-control form-control-lg" />
								<span class="text-danger text-small">필수 정보입니다.</span>
								<span class="text-danger text-small">8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.</span>
							</div>

							<div class="form-outline mb-4">
								<label class="form-label" for="form3Example4cdg">비밀번호 확인</label>
								<input type="password" id="form3Example4cdg" class="form-control form-control-lg" />
								<span class="text-danger text-small">필수 정보입니다.</span>
								<span class="text-danger text-small">비밀번호가 일치하지 않습니다.</span>
							</div>

							<div class="form-check d-flex justify-content-center mb-5">
								<input class="form-check-input me-2" type="checkbox" value="" id="form2Example3cg" />
								<label class="form-check-label" for="form2Example3g">
									<a href="#!" class="text-body"> <u>서비스 이용약관</u> </a>에 동의합니다.
									<span class="text-danger">(필수)</span>
								</label>
							</div>

							<div class="d-grid gap-2">
								<button type="button" class="btn btn-register btn-primary btn-block text-white">가입하기</button>
							</div>

							<p class="text-center text-muted mt-5 mb-0">
								이미 회원이신가요? <a href="#!" class="fw-bold text-body"><u>로그인하기</u></a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
.text-small {
	font-size: 0.8em;
}
.btn-register {
	height: 50px;
}
</style>
