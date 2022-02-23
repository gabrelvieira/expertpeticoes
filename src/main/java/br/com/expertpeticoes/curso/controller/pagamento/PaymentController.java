package br.com.expertpeticoes.curso.controller.pagamento;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private DadosPayment dados;
	
	@GetMapping
	public String paymentCard() throws Exception {

		MercadoPago.SDK.setAccessToken(dados.getAcessToken());

		Preference preference = new Preference();
		
		PaymentMethods paymentMethods = new PaymentMethods();
		paymentMethods.setInstallments(5);
		
		Item item = new Item();
		item.setId("123")
		.setTitle("Petições do Expert Petições")
		.setQuantity(1)
		.setUnitPrice(Float.valueOf(dados.getValor().toString()))
		.setDescription("Coletania de petições");
		
	
		BackUrls back = new BackUrls()
				.setSuccess("http://localhost/notification")
				.setFailure("http://localhost/notification")
				.setPending("http://localhost/notification");
		preference.setPaymentMethods(paymentMethods);
		try {
			preference.appendItem(item)
				.setBackUrls(back);
			preference.save();
		} catch (Exception e) {
			
		}
		return "redirect:" + preference.getSandboxInitPoint();
	}

	

}
