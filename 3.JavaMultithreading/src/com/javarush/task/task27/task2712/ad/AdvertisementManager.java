package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by PBunegin on 27.10.2017.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> availableVideos = storage.list();
        if (availableVideos.isEmpty())
            throw new NoVideoAvailableException();
        List<Advertisement> showVideos = new ArrayList<>();
        for (Advertisement ad: availableVideos) {
            if (ad.getDuration() <= timeSeconds && ad.getHits() > 0)
                showVideos.add(ad);
        }
        showVideos = getShowVideos(showVideos, 0);
        if (showVideos.isEmpty())
            throw new NoVideoAvailableException();




        Collections.sort(showVideos, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result == 0)
                    result = Long.compare(o1.getAmountPerOneDisplaying() / o1.getDuration(), o2.getAmountPerOneDisplaying() / o2.getDuration());
                return result;
            }
        });
        Collections.reverse(showVideos);
        for (Advertisement ad : showVideos) {
            ConsoleHelper.writeMessage(String.format("%s  is displaying... %d, %d",
                    ad.getName(), ad.getAmountPerOneDisplaying(), ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
            ad.revalidate();
        }

    }

    public List<Advertisement> getShowVideos(List<Advertisement> inList, int start) {
        List<Advertisement> result = new ArrayList<>();
        int timeLeft = timeSeconds - summOfTime(inList);
        Advertisement ad;

        for (int i = start; i < storage.list().size(); i++) { // проходим по сторейдж массиву
            ad = storage.list().get(i);
            if (!inList.contains(ad) && ad.getHits() > 0 && (ad.getDuration() <= timeLeft)) {
                inList.add(ad);
                result = checkWhoBetter(inList, getShowVideos(inList, i));
            }
        }
        return result;
    }

    // выводит сумму прибыли за показ листа
    public int summOfListMoney(List<Advertisement> list) {
        int summ = 0;
        for (Advertisement ad : list) {
            summ += ad.getAmountPerOneDisplaying();
        }
        return summ;
    }

    // возвращает суммарную длительность роликов в листе
    public int summOfTime(List<Advertisement> list) {
        int summ = 0;
        for (Advertisement ad : list) {
            summ += ad.getDuration();
        }
        return summ;
    }

    //сравнивает два листа по требованиям
    public List<Advertisement> checkWhoBetter(List<Advertisement> check, List<Advertisement> tmp) {
        List<Advertisement> result = new ArrayList<>();
        if (summOfListMoney(check) > summOfListMoney(tmp)) result = check;
        if (summOfListMoney(check) < summOfListMoney(tmp)) result = tmp;
        if (summOfListMoney(check) == summOfListMoney(tmp)) {
            if (summOfTime(check) > summOfTime(tmp)) result = check;
            if (summOfTime(check) < summOfTime(tmp)) result = tmp;
            if (summOfTime(check) == summOfTime(tmp)) {
                if (check.size() > tmp.size()) result = check;
                else result = tmp;
            }
        }
        return result;
    }
}