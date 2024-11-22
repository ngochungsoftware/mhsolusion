Create by Le Ngoc Hung 

MapStruct
   ->  example and explain
-> 
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    // Ánh xạ giữa DTO và Entity
    User mapDtoToEntity(UserDTO userDTO);
    UserDTO mapEntityToDto(User user);

    // Ánh xạ giữa Request và Entity
    @Mapping(source = "fullName", target = "name") // Nếu field có tên khác nhau
    User mapRequestToEntity(UserRequest userRequest);
    @Mapping(source = "name", target = "fullName") // Nếu field có tên khác nhau
    UserRequest mapEntityToRequest(User user);

    // Cập nhật một phần Entity từ Request
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserRequest userRequest, @MappingTarget User user);

    // Ánh xạ danh sách
    List<UserDTO> mapEntityListToDtoList(List<User> users);
    List<User> mapDtoListToEntityList(List<UserDTO> userDTOs);
}


@ExceptionHandler cho phép bạn xử lý các ngoại lệ một cách tập trung mà không cần lặp lại mã xử lý lỗi trong từng phương thức của controller.

SLF4J
Log các thông tin cần thiết:

Sử dụng logger.info() để ghi lại các sự kiện quan trọng như thêm, cập nhật, hoặc xóa dữ liệu.
Sử dụng logger.error() để ghi lại các lỗi xảy ra trong ứng dụng.
Sử dụng logger.warn() nếu phát hiện các tình huống không phải lỗi nghiêm trọng nhưng cần lưu ý.
Cấu trúc thông báo log:

Sử dụng cú pháp {} của SLF4J để truyền tham số một cách rõ ràng.
Bao gồm thông tin cần thiết (như ID, đối tượng request) để hỗ trợ việc debug.
Kết quả
Khi xảy ra lỗi, log sẽ ghi lại thông tin chi tiết, giúp dễ dàng xác định vấn đề.
Các thao tác thông thường (GET, POST, PUT, DELETE) cũng được ghi lại để theo dõi hoạt động của hệ thống.
GlobalExceptionHandler giúp tập trung xử lý lỗi và ghi log ở một nơi duy nhất.