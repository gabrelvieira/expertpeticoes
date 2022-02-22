package br.com.expertpeticoes.curso.controller.pagamento;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mercadopago.MercadoPago;
import com.mercadopago.resources.MerchantOrder;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.merchantorder.MerchantOrderPayment;
import com.mercadopago.resources.datastructures.payment.Identification;
import com.mercadopago.resources.datastructures.payment.Payer;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.ExcludedPaymentType;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.PaymentMethods;

@Controller
@RequestMapping("/payment")
public class PaymentController {

	private static final String ACCESS_TOKEN = "TEST-3256739264421310-021300-d2d0f21bf5d9d12f56409ded7aa3f2fd-306346999";

	@GetMapping("/card")
	public String paymentCard() throws Exception {

		MercadoPago.SDK.setAccessToken(ACCESS_TOKEN);

		Preference preference = new Preference();

		
		PaymentMethods paymentMethods = new PaymentMethods();
		paymentMethods.setInstallments(5);
		
		Item item = new Item();
		item.setId("123")
		.setTitle("Petições do Expert Petições")
		.setQuantity(1)
		.setUnitPrice((float) 50)
		.setDescription("Coletania de petiçõesssss");
		
		try {
			MercadoPago.SDK.setAccessToken(ACCESS_TOKEN);
		} catch (Exception e) {
			System.out.println("opa");
		}
		
		BackUrls back = new BackUrls()
				.setSuccess("http://localhost/notification")
				.setFailure("http://localhost/notification")
				.setPending("http://localhost/notification");
		preference.setPaymentMethods(paymentMethods);
		try {
			preference.appendItem(item)
				.setBackUrls(back)
				.setNotificationUrl("https://webhook.site/c1caf461-04d6-4a14-81b3-16887c9a123d");
			preference.save();
		} catch (Exception e) {
			
		}
		return "redirect:" + preference.getSandboxInitPoint();
	}

	

}
