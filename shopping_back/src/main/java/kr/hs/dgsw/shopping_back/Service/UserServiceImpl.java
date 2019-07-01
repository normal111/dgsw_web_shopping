package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Category;
import kr.hs.dgsw.shopping_back.Domain.Product;
import kr.hs.dgsw.shopping_back.Domain.User;
import kr.hs.dgsw.shopping_back.Repository.CategoryRepository;
import kr.hs.dgsw.shopping_back.Repository.ProductRepository;
import kr.hs.dgsw.shopping_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    private void init() {
        User user = this.userRepository.save(new User("q", "q", "user1", "010", "010", "50146", "대소고", "이메일"));

        this.categoryRepository.save(new Category("상의(남)"));
        this.categoryRepository.save(new Category("하의(남)"));
        this.categoryRepository.save(new Category("상의(여)"));
        this.categoryRepository.save(new Category("하의(여)"));
        this.categoryRepository.save(new Category("구두"));
        this.categoryRepository.save(new Category("가방"));
        this.categoryRepository.save(new Category("소품"));

        this.productRepository.save(new Product("main", 0,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\main.jpg",
                "main", -1l, "main", 0, "main",
                "main", "main"));

        addMan();
        addWoman();
        addAccessory();
    }

    private void addMan() {
        Long upManId = categoryRepository.findByName("상의(남)").get().getId();

        this.productRepository.save(new Product("N192UTS950 스토크 오버핏 반팔 티셔츠", 39000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\NATIONALGEOGRAPHIC.jpg",
                "내셔널지오그래픽", upManId, "반팔티", 10, "#내셔널지오그래픽 #반팔 #오버핏",
                "-1'도 NATIONAL GEOGRAPHIC 일자 로고 포인트 . 후면 Big Logo Tone on tone 전사 프린트\n" +
                        "- 탄탄한 밀도의 C/P 원단 사용\n" +
                        "- FIT : 오버 핏 (Over Fit)\n" +
                        "- 과하지 않은 semi over fit 을 적용\n" +
                        "- 적당한 두께감으로 형태 유지가 잘 되며, 베이스레이어로도 적합\n" +
                        "- 편안한 움직임을 위한 매끄러운 재봉선 처리\n" +
                        "- 우측 하단 Point LabeL",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        this.productRepository.save(new Product("OUTLINE LOGO TEE LIME(MG1JMMT508A)", 29000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\ISVT07.jpg",
                "VIVASTUDIO", upManId, "반팔티", 10, "#로고 #반팔티셔츠",
                "스테디셀러 레터링을 활용한 감각적인 컬러 조화가\n" +
                        "돋보이는 제품 입니다. 다양하고, 유니크한 컬러로 출시되어, 취향에 맞게 착용 가능합니다.\n" +
                        "뒤틀림과 수축 방지를 위해 원단 상태로 고온에서 (80℃) 두 번의 덤블 텐타가공을 했습니다.\n" +
                        "RIB 원단 또한 cotton 100% 원사에 복원력이 강한 140D의 고강력 스판사를 사용하여 목 늘어남을 방지하였습니다.\n",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        Long downManId = categoryRepository.findByName("하의(남)").get().getId();

        this.productRepository.save(new Product("라이트웨이트 테이퍼드 밴딩 크롭 슬랙스", 29900,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\MUSINSA_STANDARD.jpg",
                "무신사", downManId, "슬랙스", 10, "#9부 #크롭 팬츠 #밴딩 바지 #슬랙스",
                "편안하면서도 슬림한 테이퍼드 핏의 크롭 슬랙스. \n" +
                        "4％의 폴리우레탄이 포함된 양방향 스트레치 I/P 원단을 사용해 신축성이 뛰어나 편안한 착용감고 활동성을 보장한다. \n" +
                        "사계절용 슬랙스에 비해 얇욘 두께와 가벼운 중량으로 제작해 여름철까지 무리없이 착용 가능하다. \n" +
                        "허리 양옆으로는 이중으로 구성된 사이드 밴딩을 넣어 편안한 착용을 돕는다. \n" +
                        "다양한 기능적 요소와 편리성을 갖춘 데일리 아이템으로 활용도가 높은 아이템이다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        this.productRepository.save(new Product("[세트 상품] [패키지] BASIC HALF PANTS [GSP020H23]", 34900,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\GSP020H23.jpg",
                "GROOVE RHYME", downManId, "반바지", 10, "#쇼트팬츠 #반바지 #면바지",
                "그루브라입 스테디셀러 베이직하프팬츠는 합라적 인 가격과 다양한컬러 더불어 \n" +
                        "고품질의 퀄리티를 유지하여 많은 사랑을 받은 상품입니다. \n" +
                        "이번 2019년 시즌도 한층 업그레이드 된 2019년 신상 그루브라임 베이직 하프팬츠! ",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));
    }

    private void addWoman() {
        Long upWomanId = categoryRepository.findByName("상의(여)").get().getId();

        this.productRepository.save(new Product("유니섹스 키치 엠보더리 티셔츠 atb303u(White)", 45000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\902657135.jpg",
                "ANDERSSON BELL", upWomanId, "반팔티", 10, "#앤더슨벨 #티셔츠 #반팔티셔츠 #반팔",
                "엔더슨벨의 2019 S/S COLLECTION \"UNISEX KITSCH EMBROIDERY T-SHIRT\" 입니다.\n" +
                        "밀도가 높아 내구성이 좋으며 효소 바이오 가공과 피치 가공까지 들어간 원단입니다.\n" +
                        "프론트에 멀티컬러 로고자수로 키치한 포인트를 주었습니다.\n" +
                        "자연스러운 드랍숄더에 여유로운 실루옛으로 남녀 모두 편안하게 착용 가능한 데일리 아이템 입니다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        this.productRepository.save(new Product("TIE-DYE DROP-SHOULDER 1/2 TEE (Pink)", 39000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\19SUM-03-PK.jpg",
                "A NOTHING", upWomanId, "반팔티", 10, "#티셔츠 #물나염 #타이다이 #어낫띵 #반팔",
                "일본 수출만을 전문으로 하는\n" +
                        "프리미엄급 원단 업체와의 제휴를 통해,\n" +
                        "최고급 코튼 원단에 홀치기 염색을 하여 제작한\n" +
                        "타이 다이 드롭 숄더 반팔 티셔츠입니다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        Long downWomanId = categoryRepository.findByName("하의(여)").get().getId();

        this.productRepository.save(new Product("윈터 빅 리니어 레깅스 (FS2IPA4152FINA)", 49000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\1100FS2IPA4152FINA.jpg",
                "FILA", downWomanId, "레깅스", 10, "#로고 #FILA #휠라",
                "FILA 빅 리니어 로고 레깅스\n" +
                        "윈터시즌에 적합한 두께감의 코톤스판싱글 소재 사용\n" +
                        "허벅지 라인에 빅 로고를 프린트하여 포인트를 줌",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        this.productRepository.save(new Product("낭낭한 슬림진_SPTJ925G15", 39900,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\SPTJ925G15.jpg",
                "A NOTHING", downWomanId, "청바지", 10, "#긴바지 #데님 팬츠 #데님 #청바지 #바지",
                "일본 수출만을 전문으로 하는\n" +
                        "프리미엄급 원단 업체와의 제휴를 통해,\n" +
                        "최고급 코튼 원단에 홀치기 염색을 하여 제작한\n" +
                        "타이 다이 드롭 숄더 반팔 티셔츠입니다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));
    }

    private void addAccessory() {
        Long shoesId = categoryRepository.findByName("구두").get().getId();

        this.productRepository.save(new Product("1461 모노 3홀 블랙 스무스 래더 R14345001", 190000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\R14345001.jpg",
                "DR.MARTENS", shoesId, "남성구두", 10, "#drmartens #DRM-R14345001 #닥터마틴",
                "영국을 대표하는 신발 브랜드로 군화처럼 생긴부츠 종류가 유명하다.\n" +
                        "일반 단화처럼 생긴 1461 단화와 발목 길이의 1460 미드컷 부츠가 인기가 있다.\n" +
                        "우리나라에서는 드라마 '꽃보다 남자' 에서 구혜선이 신고 나온 부츠로 유명세를 타기도 했다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        this.productRepository.save(new Product("새들 펌프스 아이보리", 198000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\P00000CP.jpg",
                "BLUEVINE", shoesId, "여성구두", 10, "#구두 #수제화 #펌프스",
                "BLUEVINE is a handmade shoe brand inspired by modern women’s lifestyle.\n" +
                        "With more than 10 years of shoe-making skills incorporated with\n" +
                        "design experiences from French luxury fashion houses.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        Long bagId = categoryRepository.findByName("가방").get().getId();

        this.productRepository.save(new Product("빅 샷 백팩_NM2DK55A", 140000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\NM2DK55A.jpg",
                "THE NORTH FACE", bagId, "백팩", 10, "#빅샷 #백팩 #노스페이스 #가방",
                "- 수납에 충실한 오리지널 빅샷 모델\n" +
                        "- 피로감을 덜어주는 FLEXVENT 멜빵\n" +
                        "- 메쉬 소재의 등판과 여러 조절 버클로 편안한 착용감 제공\n" +
                        "- 용량 30Ｌ, 무게 12206",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        this.productRepository.save(new Product("MODESTO HQ 숄더백&토트백_블랙", 49000,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\mhq01.jpg",
                "NATIONAL PUBLICITY", bagId, "토트백", 10, "#가방 #내셔널 퍼블리시티 #토트백",
                "내셔널 퍼블리시티의 시그니처 가방 모데스토 HQ숄더. 토트 겸용 가방입니다.\n" +
                        "고금스러운 소재와 군더더기 없는 디자인으로 남녀 누구나 사용하실 수 있습니다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        Long accessoryId = categoryRepository.findByName("소품").get().getId();

        this.productRepository.save(new Product("앤더슨 유브이 블로킹 엄브렐라 aaa210u(Black)", 29500,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\902696637.jpg",
                "ANDERSSON BELL", accessoryId, "우산", 10, "#anderssonbell #우산 #앤더슨벨",
                "엔더슨벨의 “ANDERSSON UV BLOCKING UMBRELLA\" 입니다.\n" +
                        "발수 및 방수가공이 처리된 UV코팅 처리한 우양산 입니다.\n" +
                        "우산 전면에 다양한 앤더슨별 로고 프린트가 있습니다.\n" +
                        "앤더슨벨 로고가 포인트 되어 트랜디한 무드들 연출 하며,\n" +
                        "우양산으로 다양한 스타일링과 활용도가 좋은 아이탬 입니다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));

        this.productRepository.save(new Product("엑스피어 x-bt002 원형 소가죽 벨트 폭 3.2", 36800,
                "D:\\Other\\Project\\IntelliJ\\web_shopping\\shopping_back\\upload\\x-bt003.jpg",
                "XPIER", accessoryId, "벨트", 10, "#엑스피어 #XPIER #벨트 #가죽벨트",
                "소가죽 재질로 페이크 제품의 벗겨짐등을 방지 했습니다.\n" +
                        "버클 부분은 스테인레스재질로 고급스러운 재질 표현을 했습니다.",
                "제품의 초기불량에 따른 교환/반품(환불)일 경우\n" +
                        "1. 고객센터로 문의 후 처리 가능합니다.\n" +
                        "2. 상품 개봉 후 소비자 부주의에 따른 제품의 파손이나 결함은 불량으로 인한 환불 및 교환 사유가 되지 않습니다."));
    }

    @Override
    public List<User> selectUser() {
        return userRepository.findAll();
    }

    @Override
    public User selectUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User loginUser(User user) {
        return userRepository.findByIdAndPassword(user.getId(), user.getPassword()).orElse(null);
    }

    @Override
    public User insetUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.findById(user.getId())
                .map(found -> {
                    found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                    found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                    found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
                    found.setMobile(Optional.ofNullable(user.getMobile()).orElse(found.getMobile()));
                    found.setPostal_code(Optional.ofNullable(user.getPostal_code()).orElse(found.getPostal_code()));
                    found.setAddress(Optional.ofNullable(user.getAddress()).orElse(found.getAddress()));
                    found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteUser(String id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
