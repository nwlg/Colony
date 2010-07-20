package uk.co.siriusit.acegi.captcha;

import org.acegisecurity.captcha.CaptchaServiceProxy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

public class JCaptchaServiceProxy implements CaptchaServiceProxy, InitializingBean {

	private DefaultManageableImageCaptchaService jCaptchaService;
	
	public void setjCaptchaService(
			DefaultManageableImageCaptchaService jCaptchaService) {
		this.jCaptchaService = jCaptchaService;
	}

	@Override
	public boolean validateReponseForId(String id, Object captchaResponse) {
		return jCaptchaService.validateResponseForID(id, captchaResponse);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.jCaptchaService, "jCaptchaService must be specified");
	}

}
