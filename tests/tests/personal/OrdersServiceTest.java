package tests.personal;

import com.cryptoRari.entities.Orders.MarketOrder;
import com.cryptoRari.entities.Orders.OrderResponse;
import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.personal.OrdersService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;
import org.junit.Test;

public class OrdersServiceTest {

    OrdersService ordersService;
    TimeService timeService;

    public OrdersServiceTest() {
        this.ordersService = new OrdersService(
                Environment.API_KEY,
                Environment.PASSPHRASE,
                Environment.SECRET
        );
        this.timeService = new TimeService();
    }

    @Test
    public void testPostOrder() {
        MarketOrder marketOrder = new MarketOrder();

        //Setup to buy 1 btc, market order
        marketOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        marketOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        marketOrder.setSize(1);
        marketOrder.setType(Constants.GDAX.Orders.Type.MARKET);

        //Get time
        String epochTime = timeService.getTime().getEpoch();

        //Send order to server
        OrderResponse orderResponse = ordersService.postOrder(marketOrder, epochTime);

        System.out.print(orderResponse);
    }
}

