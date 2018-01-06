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
import java.util.ArrayList;

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

    //This test may fail due to low funds, will be fixed soon
    @Test
    public void testPostOrder() {
        //Get time
        String epochTime = timeService.getTime().getEpoch();

        //Setup to buy 1 btc, market order
        MarketOrder marketOrder = new MarketOrder();
        marketOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        marketOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        marketOrder.setSize("0.10");
        marketOrder.setType(Constants.GDAX.Orders.Type.MARKET);
        System.out.println("Market order id: " + marketOrder.getClient_oid());

        //Send order to server
        OrderResponse marketResponse = ordersService.postOrder(marketOrder, epochTime);
        System.out.print(marketResponse);

        //Setup one limit order
        LimitOrder limitOrder = new LimitOrder();
        limitOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        limitOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        limitOrder.setPrice("15000.00");
        limitOrder.setSize("1.0");
        limitOrder.setType(Constants.GDAX.Orders.Type.LIMIT);

        //Send order to server
        OrderResponse limitResponse = ordersService.postOrder(limitOrder, epochTime);
        System.out.print(limitResponse);

        //Setup one stop order
        StopOrder stopOrder = new StopOrder();
        stopOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        stopOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        stopOrder.setPrice("1000");
        stopOrder.setSize("1");
        stopOrder.setFunds("100");
        stopOrder.setType(Constants.GDAX.Orders.Type.STOP);

        //Send order to server
        OrderResponse stopResponse = ordersService.postOrder(stopOrder, epochTime);
        System.out.print(limitResponse);

        assertTrue( stopResponse != null);
        assertTrue(marketResponse != null);
        assertTrue(limitResponse != null);
    }

    @Test
    public void getOrdersTest() {
        //Get current Time
        String epochTime = timeService.getTime().getEpoch();

        //Create single order to use in test
        LimitOrder limitOrder = new LimitOrder();
        limitOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        limitOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        limitOrder.setPrice("15000.00");
        limitOrder.setSize("1.0");
        limitOrder.setType(Constants.GDAX.Orders.Type.LIMIT);
        OrderResponse limitResponse = ordersService.postOrder(limitOrder, epochTime);
        System.out.print(limitResponse);

        //Get orders with all statuses
        ArrayList<String> statuses = new ArrayList<>();
        statuses.add(Constants.GDAX.Orders.Statuses.ALL);

        ArrayList<OrderResponse> responseList = ordersService.getOrders(statuses, epochTime);
        for(OrderResponse response : responseList ) {
            System.out.println(response);
        }

        assertTrue(responseList != null);
    }

    @Test
    public void cancelAllOrdersTest() {
        //Get current Time
        String epochTime = timeService.getTime().getEpoch();

        //Create BTC order to use in test
        LimitOrder limitOrder = new LimitOrder();
        limitOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        limitOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        limitOrder.setPrice("15000.00");
        limitOrder.setSize("1.0");
        limitOrder.setType(Constants.GDAX.Orders.Type.LIMIT);
        OrderResponse limitResponse = ordersService.postOrder(limitOrder, epochTime);
        System.out.print(limitResponse);

        ArrayList<String> deletedIds = ordersService.cancelAllOrders("", epochTime);
        System.out.println(deletedIds);

        assertTrue(deletedIds != null);
        assertTrue(deletedIds.contains(limitResponse.getId()));
    }

    @Test
    public void cancelAllOrdersBitCoinOnlyTest() {
        //Get current Time
        String epochTime = timeService.getTime().getEpoch();

        //Create single order to use in test
        LimitOrder limitOrder = new LimitOrder();
        limitOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        limitOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        limitOrder.setPrice("15000.00");
        limitOrder.setSize("1.0");
        limitOrder.setType(Constants.GDAX.Orders.Type.LIMIT);
        OrderResponse limitResponse = ordersService.postOrder(limitOrder, epochTime);
        System.out.print(limitResponse);

        ArrayList<String> deletedIds = ordersService.cancelAllOrders(Constants.GDAX.Currencies.BITCOIN, epochTime);

        System.out.println(deletedIds);

        assertTrue(deletedIds != null);
        assertTrue(deletedIds.contains(limitResponse.getId()));
    }

    @Test
    public void cancelOrder() {
        //Get current Time
        String epochTime = timeService.getTime().getEpoch();

        //Setup one stop order
        StopOrder stopOrder = new StopOrder();
        stopOrder.setProduct_id(Constants.GDAX.Currencies.BITCOIN);
        stopOrder.setSide(Constants.GDAX.Orders.Side.BUY);
        stopOrder.setPrice("1000");
        stopOrder.setSize("1");
        stopOrder.setFunds("100");
        stopOrder.setType(Constants.GDAX.Orders.Type.STOP);

        //Send order to server
        OrderResponse stopResponse = ordersService.postOrder(stopOrder, epochTime);
        System.out.print(stopResponse);

        String cancelResponse = ordersService.cancelOrder(stopResponse.getId(), epochTime);

        System.out.println(cancelResponse);

        String alreadyCanceledResponse = ordersService.cancelOrder(stopResponse.getId(), epochTime);

        System.out.println(alreadyCanceledResponse);

        assertTrue(cancelResponse != null);
    }
}

