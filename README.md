# kafka_order_event_processing

“Tôi đã xây dựng một ứng dụng xử lý đơn hàng sử dụng Apache Kafka. Khi một đơn hàng được tạo, một sự kiện OrderCreatedEvent sẽ được gửi vào topic Kafka. Consumer sẽ xử lý và lưu thông tin này vào CSDL. Nếu quá trình xử lý lỗi quá 3 lần, sự kiện sẽ được đẩy sang dead-letter topic. Mục tiêu là tách biệt producer và consumer, đảm bảo hệ thống dễ mở rộng, có khả năng ghi lại toàn bộ event để xử lý lại khi cần.”
