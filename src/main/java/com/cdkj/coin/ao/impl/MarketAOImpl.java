package com.cdkj.coin.ao.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cdkj.coin.ao.IMarketAO;
import com.cdkj.coin.bo.ICurrencyRateBO;
import com.cdkj.coin.bo.IMarketBO;
import com.cdkj.coin.domain.CurrencyRate;
import com.cdkj.coin.domain.Market;
import com.cdkj.coin.dto.req.XN625291Req;
import com.cdkj.coin.enums.ECoin;
import com.cdkj.coin.enums.ECurrency;
import com.cdkj.coin.enums.EMarketOrigin;

/**
 * Created by tianlei on 2017/十一月/13.
 */
@Service
public class MarketAOImpl implements IMarketAO {

    @Autowired
    IMarketBO marketBO;

    @Autowired
    ICurrencyRateBO currencyRateBO;

    @Override
    public Market marketByCoinType(String coinType) {

        return this.marketBO.marketByCoinTypeAndOrigin(coinType,
            EMarketOrigin.BITFINEX.getCode());

    }

    @Override
    public List<Market> marketListByReq(XN625291Req req) {

        return this.marketBO.marketListByCondation(null);

    }

    public void obtainMarket() {

        // 1.从bitfinex 获取行情
        this.obtainBitfinexMarket();

        // 2.从okex 获取行情
//        this.obtainOkexMarket();

    }

    private void obtainOkexMarket() {

        // 获取usd 的行情
        // {
        // date: "1510573295",
        // ticker: {
        // high: "319.00",
        // vol: "9799.39",
        // last: "313.71",
        // low: "285.00",
        // buy: "313.71",
        // sell: "313.75"
        // }
        // }
        String requestStr = "https://www.okex.com/api/v1/ticker.do?symbol=eth_usdt";
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().get().url(requestStr).build();
        Call call = okHttpClient.newCall(request);
        try {

            Response response = call.execute();
            String jsonStr = response.body().string();

            Map map = (Map) JSON.parseObject(jsonStr, HashMap.class);
            Map tickerMap = (Map) map.get("ticker");

            Market market = new Market();
            market.setReferCurrency(ECurrency.CNY.getCode());
            market.setCoin(ECoin.ETH.getCode());
            market.setUpdateDatetime(new Date());
            market.setLastPrice(this.convertPriceToRMB((String) tickerMap
                .get("last")));
            market.setVolume((String) tickerMap.get("vol"));

            BigDecimal bid = this.convertPriceToRMB((String) tickerMap
                .get("buy"));
            BigDecimal ask = this.convertPriceToRMB((String) tickerMap
                .get("sell"));
            market.setAsk(ask);
            market.setBid(bid);
            market.setMid(bid.add(ask).divide(new BigDecimal(2)));
            market
                .setLow(this.convertPriceToRMB((String) tickerMap.get("low")));
            market.setHigh(this.convertPriceToRMB((String) tickerMap
                .get("high")));

            // 确定mid
            // 保存
            this.marketBO.updateMarket(EMarketOrigin.OKEX.getCode(),
                ECoin.ETH.getCode(), market);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void obtainBitfinexMarket() {

        //
        this.obtainBitfinexMarketByUrlAndCoin(
            "https://api.bitfinex.com/v1/pubticker/ethusd", ECoin.ETH.getCode());

        //
        this.obtainBitfinexMarketByUrlAndCoin(
            "https://api.bitfinex.com/v1/pubticker/btcusd", ECoin.BTC.getCode());

        // // 获取usd 的行情
        // String requestStr = "https://api.bitfinex.com/v1/pubticker/ethusd";
        // OkHttpClient okHttpClient = new OkHttpClient();
        //
        // Request request = new
        // Request.Builder().get().url(requestStr).build();
        // Call call = okHttpClient.newCall(request);
        // try {
        //
        // Response response = call.execute();
        // String jsonStr = response.body().string();
        //
        // Map map = (Map) JSON.parseObject(jsonStr, HashMap.class);
        //
        // Market market = new Market();
        // market.setReferCurrency(ECurrency.CNY.getCode());
        // market.setCoin(ECoin.ETH.getCode());
        // market.setUpdateDatetime(new Date());
        // market.setLastPrice(this.convertPriceToRMB((String)map.get("last_price")));
        // market.setVolume((String)map.get("volume"));
        //
        // market.setMid(this.convertPriceToRMB((String)map.get("mid")));
        // market.setAsk(this.convertPriceToRMB((String)map.get("ask")));
        // market.setBid(this.convertPriceToRMB((String)map.get("bid")));
        //
        // market.setLow(this.convertPriceToRMB((String)map.get("low")));
        // market.setHigh(this.convertPriceToRMB((String)map.get("high")));
        //
        // //保存
        // this.marketBO.updateMarket(EMarketOrigin.BITFINEX.getCode(),ECoin.ETH.getCode(),market);
        //
        //
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

    }

    private void obtainBitfinexMarketByUrlAndCoin(String url, String coin) {

        String requestStr = url;
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().get().url(requestStr).build();
        Call call = okHttpClient.newCall(request);
        try {

            Response response = call.execute();
            String jsonStr = response.body().string();

            Map map = (Map) JSON.parseObject(jsonStr, HashMap.class);

            Market market = new Market();
            market.setReferCurrency(ECurrency.CNY.getCode());
            market.setCoin(ECoin.ETH.getCode());
            market.setUpdateDatetime(new Date());
            market.setLastPrice(this.convertPriceToRMB((String) map
                .get("last_price")));
            market.setVolume((String) map.get("volume"));

            market.setMid(this.convertPriceToRMB((String) map.get("mid")));
            market.setAsk(this.convertPriceToRMB((String) map.get("ask")));
            market.setBid(this.convertPriceToRMB((String) map.get("bid")));

            market.setLow(this.convertPriceToRMB((String) map.get("low")));
            market.setHigh(this.convertPriceToRMB((String) map.get("high")));

            // 保存
            this.marketBO.updateMarket(EMarketOrigin.BITFINEX.getCode(), coin,
                market);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // private void
    private BigDecimal convertPriceToRMB(String value) {

        // 获取美元的汇率
        CurrencyRate usdCurrencyRate = this.currencyRateBO
            .currencyRateByCurrency(ECurrency.USD.getCode());
        // 转换为人民币
        BigDecimal rmbValue = new BigDecimal(value).multiply(usdCurrencyRate
            .getRate());
        rmbValue.setScale(4, BigDecimal.ROUND_HALF_UP);
        return rmbValue;
    }

}
