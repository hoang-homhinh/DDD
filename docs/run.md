## How to run
Open environment -> Run
> docker-compose -f environment/docker-compose-dev.yml up
Chú ý: Khi run thành công thi sẽ tự tạo một folder `data/db_data` trong `environment`
## Giải thích
1.tuyến phòng thủ thứ nhất: sử dụng Resilience4j để giới hạn số lượng request tới service đồng thời
2.tuyến phòng thủ thứ hai: sử dụng Redis để cache dữ liệu từ service
  + bước 1: khi có request tới service, service sẽ kiểm tra xem dữ liệu đã được cache chưa
  + bước 2: nếu dữ liệu đã được cache thì trả về dữ liệu từ cache
  + bước 3: nếu dữ liệu chưa được cache thì service sẽ gọi tới service khác để lấy dữ liệu và cache dữ liệu đó
  + bước 4: trả về dữ liệu cho client
  + bước 5: dữ liệu được cache trong một khoảng thời gian nhất định
3. quản lý và monitor bằng Prometheus và Grafana
    + Prometheus: dùng để lấy dữ liệu(datasourc) từ các service: mysql, redis, project(springboot) 
    + Grafana: dùng để hiển thị dữ liệu từ Prometheus

