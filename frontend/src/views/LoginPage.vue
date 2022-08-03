<template>
	<div class="login">
		<div class="login-wrap">
			<form class="login-input" @submit.prevent="onSubmit">
				<h1>
					<a href="#"><img class="logo-img" src="" alt="logo" /></a>
				</h1>

				<div class="input-box">
					<input id="email" type="text" name="email" placeholder="이메일" v-model="id" />
					<label for="email" class="ani">이메일</label>
				</div>

				<div class="input-box">
					<input id="password" type="password" name="password" placeholder="비밀번호" v-model="pwd" />
					<label for="password" class="ani">비밀번호</label>
				</div>

				<div class="form-check">
					<input
						type="checkbox"
						class="form-check-input"
						id="save-email"
						name="checkbox"
						v-model="isSaveId"
						value="true"
					/>
					<label for="save-email" class="form-check-label">이메일 저장</label>
					<a href="#">회원가입</a>
				</div>

				<div class="btn-login-group">
					<button type="submit" class="btn-login">로그인</button>
					<a class="btn-login btn-google" href="http://localhost:8080/oauth2/authorization/google">
						<span class="icon-social icon-google"></span>
						구글 로그인
					</a>
					<a class="btn-login btn-naver" href="http://localhost:8080/oauth2/authorization/naver">
						<span class="icon-social icon-naver"></span>
						네이버 로그인
					</a>
					<a class="btn-login btn-kakao" href="http://localhost:8080/oauth2/authorization/kakao">
						<span class="icon-social icon-kakao"></span>
						카카오 로그인
					</a>
				</div>
			</form>
		</div>
	</div>
</template>

<script>
import { loginApi } from '@/api/account';

export default {
	components: {},
	mounted() {
		const savedId = window.localStorage.getItem('remember-me');
		if (savedId) {
			this.isSaveId = true;
			this.id = savedId;
		}
	},
	data() {
		return {
			id: '',
			pwd: '',
			isSaveId: false,
		};
	},
	methods: {
		async onSubmit() {
			if (this.id === null || this.id === '') {
				alert('아이디를 입력해주세요');
				return;
			}
			if (this.pwd === null || this.pwd === '') {
				alert('비밀번호를 입력해주세요');
				return;
			}
			try {
				const { data } = await loginApi({ email: this.id, password: this.pwd });
				console.log(data);
			} catch (error) {
				console.log(error);
				this.initForm();
			}
		},
		initForm() {
			this.id = '';
			this.pwd = '';
		},
		onSaveId() {
			// 로그인 성공하고 isSaved가 true일 경우 localStorage에 아이디 저장
			window.localStorage.setItem('remeber-me', this.id);
		},
	},
};
</script>
<style lang="scss" scoped>
@import '../assets/scss/custom.scss';

.logo-img {
	width: 100%;
}

.login {
	width: 100%;
	.login-wrap {
		margin: 0 auto;
		max-width: 480px;
		width: 90%;

		form {
			width: 100%;
			box-sizing: border-box;
			padding: 10px;
			.input-box {
				position: relative;
				margin: 10px 0;
				input {
					background: transparent;
					border: none;
					border-bottom: solid 1px #999;
					padding: 20px 0px 5px 0px;
					font-size: 14pt;
					width: 100%;
					&::placeholder {
						color: transparent;
					}
					&:focus,
					&:not(:placeholder-shown) {
						border-bottom: solid 1px $primary;
						outline: none;
					}
				}
			}

			input:placeholder-shown + label.ani {
				color: #999;
				font-size: 14pt;
				top: 15px;
			}
			input:focus + label.ani,
			label.ani {
				color: $primary;
				font-size: 10pt;
				pointer-events: none;
				position: absolute;
				left: 0px;
				top: 0px;
				transition: all 0.2s ease;
				-webkit-transition: all 0.2s ease;
				-moz-transition: all 0.2s ease;
				-o-transition: all 0.2s ease;
			}
			.btn-login-group {
				a {
					cursor: pointer;
					text-decoration: none;
				}
				.btn-login {
					&:nth-child(1) {
						margin-bottom: 50px;
					}
					display: block;
					text-align: center;
					background-color: $primary;
					border: none;
					color: white;
					width: 100%;
					height: 50px;
					line-height: 50px;
					font-size: 14pt;
					margin-top: 12px;
				}
				.btn-google {
					background-color: #fff !important;
					border: 1px solid #777;
					color: #777;
					box-sizing: border-box;
				}
				.btn-naver {
					background-color: #03c759 !important;
				}
				.btn-kakao {
					background-color: #fee500 !important;
					color: #333;
					img {
						width: 100%;
					}
				}
			}

			.form-check {
				label,
				a {
					color: #999;
					font-size: 14px;
				}
				a {
					float: right;
					line-height: 24px;
				}
			}
		}
	}

	.icon-social {
		line-height: 50px;
		height: 20px;
		width: 20px;
		display: inline-block;
		background-size: contain;
		background-repeat: no-repeat;
		vertical-align: text-top;
		margin-right: 10px;
	}
	.icon-google {
		background-image: url(../assets/img/google.png);
	}
	.icon-naver {
		background-image: url(../assets/img/naver.png);
	}
	.icon-kakao {
		background-image: url(../assets/img/kakao.png);
	}
	.form-check-label {
		cursor: pointer;
	}
}
</style>
