package tests.personal;

import com.cryptoRari.entities.Orders.LimitOrder;
import com.cryptoRari.entities.Orders.MarketOrder;
import com.cryptoRari.entities.Orders.OrderResponse;
import com.cryptoRari.entities.Orders.StopOrder;
import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.personal.OrdersService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

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
        //Get time
        String epochTime = timeService.getTime().getEpoch();

        //Setup to buy 1 btc, market order
        MarketOrder marketOrder = new MarketOrder();
        marketOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        marketOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        marketOrder.setSize("1");
        marketOrder.setType(Constants.GDAX.Orders.Type.MARKET);

        //Send order to server
        OrderResponse marketResponse = ordersService.postOrder(marketOrder, epochTime);
        System.out.print(marketResponse);

        //Setup one limit order
        LimitOrder limitOrder = new LimitOrder();
        limitOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        limitOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        limitOrder.setPrice("300.00");
        limitOrder.setSize("1");
        limitOrder.setType(Constants.GDAX.Orders.Type.LIMIT);

        //Send order to server
        OrderResponse limitResponse = ordersService.postOrder(limitOrder, epochTime);
        System.out.print(limitResponse);

        //Setup one stop order
        StopOrder stopOrder = new StopOrder();
        stopOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        stopOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        stopOrder.setPrice("1000");
        stopOrder.setSize("4");
        stopOrder.setType(Constants.GDAX.Orders.Type.STOP);

        //Send order to server
        OrderResponse stopResponse = ordersService.postOrder(stopOrder, epochTime);
        System.out.print(stopResponse);

        assertTrue( stopResponse != null);
        assertTrue(marketResponse != null);
        assertTrue(limitResponse != null);
    }
}

