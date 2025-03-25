1. Giải thích mô hình DDD (Domain-Driven Design): 
   - có 5 thành phần chính: application, domain, infrastructure, controller,start
   - application: có 2 phụ thuộc vào domain và infrastructure:Điều phối luồng xử lý nghiệp vụ, gọi domain để thực thi nghiệp vụ mà không chứa logic
   - domain: không phụ thuộc vào bất kỳ thành phần nào khác: Chứa logic nghiệp vụ cốt lõi, bao gồm Entity, Value Object, Aggregate, Domain Service, Domain Event
   - infrastructure: phụ thuộc vào domain:Xử lý truy xuất dữ liệu, API bên ngoài, giao tiếp với hệ thống khác
   - controller: phụ thuộc vào application:Chứa logic xử lý request, response, chuyển đổi dữ liệu giữa client và application
   - start: phụ thuộc vào controller:Chứa cấu hình, khởi tạo ứng dụng
2. Có 3 công nghệ để bảo vệ hệ thống khi có request đồng thời lớn:
   - Ba thư viện này đều được sử dụng để quản lý lỗi, chịu lỗi và cung cấp khả năng dự phòng trong các hệ thống phân tán, đặc biệt là trong các kiến trúc Microservices
   - Sentinel, Hystrix, và Resilience4j.