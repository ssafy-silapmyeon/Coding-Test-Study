package footdev._5주차;

import java.util.*;

/*
goal = 문자열 가공해서 주차요금 계산해서 배열로 return 해라.

요구사항
- 입차된 후 출차내역이 존재하지 않는다면 23:59에 출차된 것으로 간주
- 누적 주차 시간이 기본 시간 이하면 기본 요금 청구
- 누적 주차 시간이 기본 시간 초과면 기본요금 + 초과한 시간에 대해서 단위 시간 마다 단위 요금 추가
    - 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면 올림
    - ⌈a⌉ = a보다 작지 않은 최소의 정수를 의미. 즉, 올림을 의미
*/

class PGS_주차_요금_계산 {

    public int[] solution(int[] fees, String[] recordsInput) {
        Map<Integer, ParkingInfo> parkingRecords = new HashMap<>();
        Map<Integer, Integer> result = new TreeMap<>();
        int n = recordsInput.length;

        Record[] records = new Record[n];
        for (int i = 0; i < n; i++) {
            records[i] = new Record(recordsInput[i]);
        }

        for (Record record : records) {
            if (record.isIn()) {
                Integer carNumber = record.getCarNumber();
                if (!parkingRecords.containsKey(carNumber)) {
                    parkingRecords.put(record.getCarNumber(), new ParkingInfo(0, record.getHour(), record.getMinute()));
                } else {
                    parkingRecords.get(carNumber)
                            .setHourAndMin(record.getHour(), record.getMinute())
                            .in();

                }
            } else {
                parkingRecords.get(record.getCarNumber())
                        .calculateSum(record.getHour(), record.getMinute())
                        .out();
            }
        }

        for (Map.Entry<Integer, ParkingInfo> entry : parkingRecords.entrySet()) {
            int carNumber = entry.getKey();
            ParkingInfo info = entry.getValue();

            if (info.isIn()) {
                info.addMinute();
            }

            result.put(carNumber, info.calculateFee(fees));
        }

        return result.values()
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

class Record {

    static final String IN = "IN";
    static final String SPLIT_WORD = ":";

    private int hour;
    private int minute;
    private final int carNumber;
    private final boolean isIn;

    public Record(String record) {
        StringTokenizer st = new StringTokenizer(record);
        convertToIntTime(st.nextToken());
        this.carNumber = Integer.parseInt(st.nextToken());
        this.isIn = st.nextToken().equals(IN);
    }

    public int getCarNumber() {
        return this.carNumber;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public boolean isIn() {
        return this.isIn;
    }

    public void setHourAndMin(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    private void convertToIntTime(String timeStr) {
        String[] times = timeStr.split(SPLIT_WORD);
        this.hour = Integer.parseInt(times[0]);
        this.minute = Integer.parseInt(times[1]);
    }
}

class ParkingInfo {

    static final int MAX_SEC = 60;
    static final int MAX_HOUR = 23;
    static final int MAX_MINUTE = 59;

    private int parkSum;
    private int hour;
    private int minute;
    private boolean isIn;

    public ParkingInfo(int parkSum, int hour, int minute) {
        this.parkSum = parkSum;
        this.hour = hour;
        this.minute = minute;
        this.isIn = true;
    }

    public ParkingInfo calculateSum(int hour, int minute) {
        if (hour > this.hour) {
            parkSum += (hour - this.hour) * MAX_SEC;
        }
        parkSum += minute - this.minute;

        return this;
    }

    public int calculateFee(int[] fees) {
        if (this.parkSum <= fees[0]) {
            return fees[1];
        }
        return fees[1] + (int)Math.ceil((double) (this.parkSum - fees[0]) / fees[2]) * fees[3];
    }

    public void addMinute() {
        this.parkSum += ((MAX_HOUR - this.hour) * MAX_SEC) + (MAX_MINUTE - this.minute);
    }

    public ParkingInfo setHourAndMin(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        return this;
    }

    public void in() {
        this.isIn = true;
    }

    public void out() {
        this.isIn = false;
    }

    public boolean isIn() {
        return this.isIn;
    }
}
